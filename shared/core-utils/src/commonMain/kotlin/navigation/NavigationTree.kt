package navigation

sealed interface NavigationTree {

    data object SplashScreen : NavigationTree

    sealed class MainFlow : NavigationTree {
        //EmployeesScreen,

    }
}