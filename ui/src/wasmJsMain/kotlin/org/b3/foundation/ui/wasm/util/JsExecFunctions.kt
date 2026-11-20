package org.b3.foundation.ui.wasm.util

@OptIn(ExperimentalWasmJsInterop::class)
internal fun isPageVisible(): Boolean =
    js("document.visibilityState === 'visible'")

@OptIn(ExperimentalWasmJsInterop::class)
internal fun observeBrowserLifecycle(
    onVisibilityChanged: (Boolean) -> Unit,
    onPageHidden: (Boolean) -> Unit,
    onPageShown: () -> Unit,
): Unit = js(
    """
    {
        const visibilityHandler = () => {
            onVisibilityChanged(document.visibilityState === "visible");
        };
        const pagehideHandler = (event) => {
            onPageHidden(event.persisted);
        };
        const pageshowHandler = () => {
            onPageShown();
        };
    
        document.addEventListener("visibilitychange", visibilityHandler);
        window.addEventListener("pagehide", pagehideHandler);
        window.addEventListener("pageshow", pageShowHandler);
        
        return () => {
            document.removeEventListener("visibilitychange", pageHiddenHandler);
            window.removeEventListener("pagehide", pagehideHandler);
            window.removeEventListener("pageshow", pageshowHandler);
        };
    }
    """
)

@OptIn(ExperimentalWasmJsInterop::class)
internal fun findViewportContainerId(): String? =
    js("document.querySelector('[data-b3-viewport]')?.id || null")
