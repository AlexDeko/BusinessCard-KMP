import SwiftUI
import bridge

struct ComposeView: UIViewControllerRepresentable {
    private let rootComponent: RootComponent
    private let backDispatcher: BackDispatcher
    
    init(rootComponent: RootComponent, backDispatcher: BackDispatcher) {
        self.rootComponent = rootComponent
        self.backDispatcher = backDispatcher
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
         MainIOSKt.MainViewController(component: rootComponent, backDispatcher: backDispatcher)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    private let rootComponent: RootComponent
    private let backDispatcher: BackDispatcher
    
    init(root: RootComponent, backDispatcher: BackDispatcher) {
        self.rootComponent = root
        self.backDispatcher = backDispatcher
    }
    
    var body: some View {
        ComposeView(rootComponent : rootComponent, backDispatcher: backDispatcher)
                .ignoresSafeArea(.all, edges: .bottom) // Compose has own keyboard handler
    }
}
