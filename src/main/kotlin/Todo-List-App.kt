fun main(){
    //TODO list app
    // View todos
    // add todos
    // remove todos
    val todoList = mutableListOf<String>()

    while (true){
        println("Todo list app")
        println("1. View Todos")
        println("2. Add a Todo")
        println("3. Remove a Todo")
        println("4. Exit the app")
        print("Enter Command: ")

        when ( readlnOrNull()?.toIntOrNull()){
            1 -> viewTasks(todoList)
            2 -> addTask(todoList)
            3 -> deleteTask(todoList)
            4 -> {
                println("Good bye...")
                break
            }
            else -> println("Enter a valid command")
        }
    }
}

//Function to view all the tasks
fun viewTasks(tasks: MutableList<String>){
    if(tasks.isEmpty()){
        println("There is no tasks")
    }else {
        println("\n Your tasks:")
        tasks.forEachIndexed {
            index, task -> println("${index + 1}: $task")
        }
    }
    println("")
}

//Function to add a new task
fun addTask(tasks: MutableList<String>){
    print("Enter a new task: ");

    val newTask = readlnOrNull();
    newTask?.let {
        if(it.isNotBlank()){
            tasks.add(it)
            println("Added successfully")
        }else {
            println("Cannot add an empty task!")
        }
    } ?: println("Please enter a valid task")
}

//Function to delete a task
fun deleteTask(tasks: MutableList<String>){
    viewTasks(tasks)
    if(tasks.isEmpty()) return

    print("Please enter the task number to delete: ")
    val input = readlnOrNull()?.toIntOrNull();

    input?.let { taskNumber ->
        if(taskNumber in 1..tasks.size){
            val removedTask = tasks.removeAt(taskNumber - 1)
            println("Removed $removedTask")
        }else {
            println("Enter a valid number in range")
        }
    } ?: println("Please enter a valid number")

}



