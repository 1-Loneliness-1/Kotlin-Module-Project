import Menu.Companion.getUserInput

class ArchiveActivity {

    private val archiveMenuElements: ArrayList<String> = arrayListOf(
        "Создать архив",
        "Выбрать уже созданный архив",
        "Выйти из программы"
    )
    private val firstLineInOutput = "Действия с архивами:"

    fun start() {
        while(true) {
            when (getUserInput(firstLineInOutput, archiveMenuElements)) {
                "0" -> goToCreateActivity()
                "1" -> ShowArchiveActivity().startShowArchiveActivity()
                "2" -> {
                    exit()
                    break
                }
            }
        }
    }

    private fun exit() {
        println("Завершение программы...")
    }

    private fun goToCreateActivity() {
        currentArchives[CreateArchiveActivity().createObject()[0]] = mutableMapOf()
    }

}