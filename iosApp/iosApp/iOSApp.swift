import SwiftUI
import bridge

@main
struct iOSApp: App {
    
    init() {
        let platformConfiguration = PlatformConfiguration()
        InitSdk().doInit(
            configuration: platformConfiguration
        )
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
