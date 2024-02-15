import SwiftUI
import bridge

struct ComposeView: UIViewControllerRepresentable {
    private let rootComponent: RootComponent
    
    init(_ root: RootComponent) {
        self.rootComponent = root
    }
    
    func makeUIViewController(context: Context) -> UIViewController {
         MainIOSKt.MainViewController(component: rootComponent)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    private let rootComponent: RootComponent
    
    init(_ root: RootComponent) {
        self.rootComponent = root
    }
    
    var body: some View {
        ComposeView(rootComponent)
                .ignoresSafeArea(.all, edges: .bottom) // Compose has own keyboard handler
    }
}
