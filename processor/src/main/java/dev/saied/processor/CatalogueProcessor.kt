package dev.saied.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFile
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSVisitorVoid

class CatalogueProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    val functions = mutableListOf<KSFunctionDeclaration>()
    private val visitor = PreviewVisitor()
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val ksAnnotateds =
            resolver.getSymbolsWithAnnotation("androidx.compose.ui.tooling.preview.Preview")
        ksAnnotateds.forEach { it.accept(visitor, Unit) }
        logger.warn("process called with ${ksAnnotateds.count()} files.")
        return emptyList()
    }

    inner class PreviewVisitor : KSVisitorVoid() {

        override fun visitFile(file: KSFile, data: Unit) {

        }

        override fun visitFunctionDeclaration(function: KSFunctionDeclaration, data: Unit) {
            if (function.annotations.any { it.shortName.asString() == "Preview" }) {
                functions.add(function)
                logger.warn(">>>>>PREVIEW:${ function.parameters.first().hasDefault }", function)
            }
        }
    }
}

class CatalogueProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        CatalogueProcessor(environment.codeGenerator, environment.logger)
}