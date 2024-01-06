import Menu.Companion.getInfoForObject

class CreateArchiveActivity: Creatable {

    override val welcomeString: String
        get() = "Добро пожаловать на экран создания архива."
    override val elementsOfCreateInterface: List<String>
        get() = listOf("Введите название архива: ", "Вы не можете создать архив без названия!\n(Название не может состоять только из пробелов)", "Архив создан успешно!\n")

    override fun createObject(): ArrayList<String> {
        return getInfoForObject(this)
    }

}