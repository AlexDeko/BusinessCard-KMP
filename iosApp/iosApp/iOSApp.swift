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
            ContentView(appDelegate.root)
		}
	}
}

class AppDelegate: NSObject, UIApplicationDelegate {

    lazy var root: RootComponent = DefaultRootComponent(
        componentContext: DefaultComponentContext(
            lifecycle: ApplicationLifecycle()
        )
    )
}
