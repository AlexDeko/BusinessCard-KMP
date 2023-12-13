package navigation

sealed interface NavigationTree {

    data object SplashScreen : NavigationTree

    enum class MainFlow : NavigationTree {
        EmployeesScreen
    }
}