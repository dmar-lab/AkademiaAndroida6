package dmar.akan.akademiaandroida.core.base

import kotlinx.coroutines.*

// Params can be delivers from a view
abstract class UseCase<out Type, in Params> {

    abstract suspend fun action(params: Params): Type

    operator fun invoke(
        params: Params,
        scope: CoroutineScope,
        executionDispatcher: CoroutineDispatcher = Dispatchers.IO,
        onResult: (Result<Type>) -> Unit = {} // default value as empty lambda
    ) {
        scope.launch {
            val result = withContext(executionDispatcher) {
                // REMEMBER this should be called only from a coroutine
                // runCatching because network operation can be failed
                runCatching { action(params) } // background thread
            }
            onResult(result) //main
        }
    }
}
