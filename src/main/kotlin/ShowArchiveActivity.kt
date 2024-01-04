import Menu.Companion.getUserInput
import OpenArchiveActivity.Companion.startOpenArchiveActivity

class ShowArchiveActivity {

    private var firstLine: String = "Доступные архивы:"
    private var showArchivesMenuElements: MutableList<String> = currentArchives.keys.toMutableList()

    fun startShowArchiveActivity() {
        if (showArchivesMenuElements.size == 0) firstLine = firstLine.plus("\nАрхивы не созданы!")
        showArchivesMenuElements.add("Назад к списку действий с архивами")
        while(true) {
            val command = getUserInput(firstLine, showArchivesMenuElements)
            when(command) {
                "${showArchivesMenuElements.size - 1}" -> {
                    println("Возврат к списку действий с архивами...\n")
                    break
                }
                else -> {
                    startOpenArchiveActivity(showArchivesMenuElements[command.toInt()])
                }
            }
        }
    }

}