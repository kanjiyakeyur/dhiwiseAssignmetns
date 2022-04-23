import kotlin.test.*

class TestNames {

    @Test
    fun testNames(){
        val flutter = Flutter("Splash Screen")
        assertEquals("splash_screen_screen",flutter.screenNameGetter())
        assertEquals("splash_screen_controller",flutter.controllerNameGetter())
        assertEquals("splash_screen_model",flutter.modelNameGetter())
        assertNotNull(flutter.screenNameGetter())
    }
}
