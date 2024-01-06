import Menu.Companion.getInfoForObject

class CreateNoteActivity: Creatable {
    override val welcomeString: String
        get() = "Добро пожаловать на экран создания заметки."
    override val elementsOfCreateInterface: List<String>
        get() = listOf("Введите название заметки: ",
            "Вы не можете создать заметку без названия!\n(Название не может состоять только из пробелов)",
            "Введите содержимое заметки: ",
            "Вы не можете создать заметку без содержания!\n(Содержание заметки не может состоять только из пробелов)",
            "Заметка успешно создана!"
        )

    override fun createObject(): ArrayList<String> {
        return getInfoForObject(this)
    }
}