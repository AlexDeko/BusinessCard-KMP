import SwiftUI
import bridge

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self)
       var appDelegate: AppDelegate
    
    init() {
        let platformConfiguration = PlatformConfiguration()
        InitSdk().doInit(
            configuration: platformConfiguration
        )
    }

	var body: some Scene {
		WindowGroup {
            ContentView(root: appDelegate.root, backDispatcher: appDelegate.backDispatcher)
		}
	}
}

class AppDelegate: NSObject, UIApplicationDelegate {
    private var stateKeeper = StateKeeperDispatcherKt.StateKeeperDispatcher(savedState: nil)
    var backDispatcher: BackDispatcher = BackDispatcherKt.BackDispatcher()

    lazy var root: RootComponent = DefaultRootComponent(
        componentContext: DefaultComponentContext(
            lifecycle: ApplicationLifecycle(),
            stateKeeper: stateKeeper,
            instanceKeeper: nil,
            backHandler: backDispatcher
        )
    )
}
