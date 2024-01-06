import Menu.Companion.getUserInput
import OpenArchiveActivity.Companion.startOpenArchiveActivity

class ArchiveActivity {

    private var firstLineInOutput = "Действия с архивами:"

    fun start() {
        while(true) {
            val namesOfCurrentArchives: List<String> = currentArchives.keys.toList()
            val archiveMenuElements: ArrayList<String> = arrayListOf(
                "Создать архив",
                "Выйти из программы"
            )

            namesOfCurrentArchives.forEach {
                archiveMenuElements.add("Открыть архив \'$it\'")
            }
            firstLineInOutput = if (currentArchives.isEmpty()) firstLineInOutput.plus("\nАрхивы не созданы!") else "Действия с архивами:"

            when (val command = getUserInput(firstLineInOutput, archiveMenuElements)) {
                "0" -> goToCreateActivity()
                "1" -> {
                    exit()
                    break
                }
                else -> {
                    startOpenArchiveActivity(namesOfCurrentArchives[command.toInt() - 2])
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