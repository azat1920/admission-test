package com.netcracker.admissiontest.questionCategory.service;

import com.netcracker.admissiontest.answer.entity.Answer;
import com.netcracker.admissiontest.answer.repository.AnswerRepository;
import com.netcracker.admissiontest.question.entity.Question;
import com.netcracker.admissiontest.question.repository.QuestionRepository;
import com.netcracker.admissiontest.question.service.QuestionService;
import com.netcracker.admissiontest.questionCategory.entity.QuestionCategory;
import com.netcracker.admissiontest.questionCategory.repository.QuestionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionCategoryService {

    @Autowired
    private QuestionCategoryRepository questionCategoryRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;


    @PostConstruct
    public void init(){
        createQuestionCategory(new QuestionCategory("Java"));
        createQuestionCategory(new QuestionCategory("Web"));
        createQuestionCategory(new QuestionCategory("Linux"));
        createQuestionCategory(new QuestionCategory("Data structures"));
        createQuestionCategory(new QuestionCategory("Databases"));

        createJavaTest();
        createLinuxTest();
        createWebTest();
        createDataStructuresTest();
        createDatabasesTest();

    }



    public List<QuestionCategory> getAll(){
        List<QuestionCategory> list = new ArrayList<>();

        for (QuestionCategory questionCategory:
             questionCategoryRepository.findAll()) {
            list.add(questionCategory);
        }

        return list;
    }

        public QuestionCategory getQuestionCategory(Long id){
            return questionCategoryRepository.findById(id).get();
        }

        public void createQuestionCategory(QuestionCategory questionCategory){
            questionCategoryRepository.save(questionCategory);
        }

        public void updateQuestionCategory(Long id, QuestionCategory questionCategory){
            questionCategoryRepository.save(questionCategory);
        }

        public void deleteQuestionCategory(Long id){
            questionCategoryRepository.deleteById(id);
        }


        private void saveQuestionAnswer(List<Question> questions, List<Answer> answers){

            for (Question question: questions
                    ) {
                questionRepository.save(question);
            }

            for (Answer answer: answers
                    ) {
                answerRepository.save(answer);
            }

        }

    private void createJavaTest(){

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        QuestionCategory qc = questionCategoryRepository.findByName("Java").get(0);


        Question q = new  Question(qc, "Чему равен размер int в байтах?");
        questions.add(q);
        answers.add(new Answer(q, "2", false));
        answers.add(new Answer(q,"4", true));
        answers.add(new Answer(q,"8",false));


        q = new  Question(qc, "Какая версия JDK является последней?");
        questions.add(q);
        answers.add(new Answer(q, "1.7",false));
        answers.add(new Answer(q, "1.8", false));
        answers.add(new Answer(q, "1.9",false));
        answers.add(new Answer(q, "1.10",true));



        q = new  Question(qc, "Как можно уничтожить объект в Java?");
        questions.add(q);
        answers.add(new Answer(q, "присвоить null всем ссылкам на объект",false));
        answers.add(new Answer(q, "вызвать Runtime.getRuntime().gc()", false));
        answers.add(new Answer(q, "вызвать метод finalize() у объекта",false));
        answers.add(new Answer(q, "этого нельзя сделать вручную",true));



        q = new  Question(qc, "Можно ли наследоваться от класса java.lang.String?");
        questions.add(q);
        answers.add(new Answer(q, "Да",false));
        answers.add(new Answer(q, "Нет",true));



        q = new  Question(qc, "Выберите модификатор, применяемый к полям класса:");
        questions.add(q);
        answers.add(new Answer(q, "volatile",true));
        answers.add(new Answer(q, "native", false));
        answers.add(new Answer(q, "strictfp",false));
        answers.add(new Answer(q, "abstract",false));



        q = new  Question(qc, "Какое из следующих утверждений верное?\n");
        questions.add(q);
        answers.add(new Answer(q, "non-static метод не может быть вызван из другого нестатического метода без создания экземпляра этого класса",false));
        answers.add(new Answer(q, "final-метод не может быть статическим", false));
        answers.add(new Answer(q, "private-метод не может быть вызван из другого метода этого класса",false));
        answers.add(new Answer(q, "non-static метод не может быть вызван из статического метода без создания экземпляра соответствующего класса",true));



        q = new  Question(qc, "В соответствии с контрактом, метод hashCode() должен возвращать одинаковые целочисленные значения для двух объектов, которые равны в соответствии с методом equals().");
        questions.add(q);
        answers.add(new Answer(q, "Необязательно", false));
        answers.add(new Answer(q, "Нет",false));
        answers.add(new Answer(q, "Да",true));



        q = new  Question(qc, "Какая строка не вызовет ошибку компиляции?");
        questions.add(q);
        answers.add(new Answer(q, "char d = 0x10000;",false));
        answers.add(new Answer(q, "char c = -1;", false));
        answers.add(new Answer(q, "char a = 0xFFFF;",true));



        q = new  Question(qc, "Из какой структуры данных \"сборщик мусора\" удалит все элементы у которых исчезла последняя ссылка на их ключ в этой структуре?");
        questions.add(q);
        answers.add(new Answer(q, "HashMap",false));
        answers.add(new Answer(q, "LinkedHashMap", false));
        answers.add(new Answer(q, "IdentityHashMap",false));
        answers.add(new Answer(q, "WeakHashMap",true));



        q = new  Question(qc, "Дана строка:\n\n" +
                "\t\tString s = \"true,false\"; \n\n" +
                "Каким способом можно сформировать новую строку, равную \"test\"?");
        questions.add(q);
        answers.add(new Answer(q, "String n = s[1] + s[4] + s[9] + s[1];",false));
        answers.add(new Answer(q, "String n = s[0] + s[3] + s[8] + s[0];", false));
        answers.add(new Answer(q, "String n = s.first() + s.last() + \"s\" + s.first();",false));
        answers.add(new Answer(q, "Ни один из предложенных",true));



        q = new  Question(qc, "Как определить длину массива myarray?");
        questions.add(q);
        answers.add(new Answer(q, "myarray.length()",false));
        answers.add(new Answer(q, "myarray.size", false));
        answers.add(new Answer(q, "myarray.size()",false));
        answers.add(new Answer(q, "myarray.length",true));



        q = new  Question(qc, "Какой результат выполнения данного кода:\n\n" +
                "Boolean b = new Boolean(\"Hello\"); \n" +
                "System.out.println(b); ");
        questions.add(q);
        answers.add(new Answer(q, "true",false));
        answers.add(new Answer(q, "Hello", false));
        answers.add(new Answer(q, "Ошибка компиляции",false));
        answers.add(new Answer(q, "false",true));


        saveQuestionAnswer(questions,answers);

    }

    private void createLinuxTest(){

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        QuestionCategory qc = questionCategoryRepository.findByName("Linux").get(0);


        Question q = new  Question(qc, "Какая команда выведет директорию, в которой сейчас находится пользователь?");
        questions.add(q);
        answers.add(new Answer(q, "dir", false));
        answers.add(new Answer(q,"pwd", true));
        answers.add(new Answer(q,"cd",false));


        q = new  Question(qc, "Что выведет команда \"echo 1+1\"");
        questions.add(q);
        answers.add(new Answer(q, "2", false));
        answers.add(new Answer(q,"1+1", true));


        q = new  Question(qc, "Как проверить, запущен ли процесс, не используя утилиты top или htop?");
        questions.add(q);
        answers.add(new Answer(q, "prcs", false));
        answers.add(new Answer(q,"ps", true));
        answers.add(new Answer(q,"ptop",false));
        answers.add(new Answer(q,"cat /.prcslist",false));



        q = new  Question(qc, "Какой из этих символов называется «конвейером» и занимается перенаправлением вывода одной программы на ввод другой?");
        questions.add(q);
        answers.add(new Answer(q, ">", false));
        answers.add(new Answer(q,"%", false));
        answers.add(new Answer(q,"@",false));
        answers.add(new Answer(q,"|",true));

        q = new  Question(qc, "Какая из нижеперечисленных команд выведет на экран количество строк в файле tproger.txt?");
        questions.add(q);
        answers.add(new Answer(q, "wc -l tproger.txt", true));
        answers.add(new Answer(q,"strc tproger.txt", false));
        answers.add(new Answer(q,"cat -str tproger.txt",false));
        answers.add(new Answer(q,"count -str tproger.txt",false));


        q = new  Question(qc, "Для чего нужна популярная в Linux утилита grep?");
        questions.add(q);
        answers.add(new Answer(q, "Для сортировки содержимого файла", false));
        answers.add(new Answer(q,"Для работы с регулярными выражениями", true));
        answers.add(new Answer(q,"Для архивации файла",false));
        answers.add(new Answer(q,"Для перемещения файла",false));





        saveQuestionAnswer(questions,answers);

    }

    private void createWebTest(){

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        QuestionCategory qc = questionCategoryRepository.findByName("Web").get(0);


        Question q = new  Question(qc, "Протоколу HTTP наиболее присущи такие признаки");
        questions.add(q);
        answers.add(new Answer(q, "Работа по принципу запрос-ответ, передача данных в виде текста и кодированных в текстовой форме данных", true));
        answers.add(new Answer(q,"Работа по принципу запрос-ответ, передача данных в формате XML", false));
        answers.add(new Answer(q,"Поддержка сеансов работы пользователей, передача данных в виде текста и кодированных в текстовую форму данных",false));
        answers.add(new Answer(q,"Работа по принципу запрос-ответ, бинарная передача данных",false));

        q = new  Question(qc, "Какой из перечисленных методов может выполняться над ресурсами:");
        questions.add(q);
        answers.add(new Answer(q, "REMOVE", false));
        answers.add(new Answer(q,"HEAD", true));
        answers.add(new Answer(q,"SET",false));
        answers.add(new Answer(q,"BODY",false));

        q = new  Question(qc, "Даты в каких форматах должны генерировать HTTP/1.1 клиенты и серверы");
        questions.add(q);
        answers.add(new Answer(q, "Fri Sep 25 20:00:00 2009", false));
        answers.add(new Answer(q,"Fri, 25 Sep 2009 20:00:00 GMT", true));
        answers.add(new Answer(q,"Friday, 25-Sep-09 20:00:00 GMT",false));

        q = new  Question(qc, "Какой из перечисленных status-кодов является валидными в соответствии со спецификацией:");
        questions.add(q);
        answers.add(new Answer(q, "000", false));
        answers.add(new Answer(q,"100", true));
        answers.add(new Answer(q,"600",false));
        answers.add(new Answer(q,"0",false));

        q = new  Question(qc, "Какой хедер в redirect-ответе сервера (например, 301 Moved Permanently или 307 Temporary Redirect) указывает месторасположение перемещенного ресурса?");
        questions.add(q);
        answers.add(new Answer(q, "Redirect", false));
        answers.add(new Answer(q,"Location", true));
        answers.add(new Answer(q,"Referer",false));
        answers.add(new Answer(q,"Host",false));

        q = new  Question(qc, "Чему эквивалентен следующий URI (укажите все подходящие варианты):\n" +
                "\n\n" +
                "http://example.com/resource/a%20a%5ea\n\n" +
                "Примечание: %20 - символ пробела, %5e - символ \"^\"");
        questions.add(q);
        answers.add(new Answer(q, "http://example.com/resource/a a%5ea", false));
        answers.add(new Answer(q, "http://example.com/resource/a a^a", false));
        answers.add(new Answer(q,"http://example.com/resource/a%20a^a", true));
        answers.add(new Answer(q,"Ничего из вышеперечисленного",false));


        saveQuestionAnswer(questions,answers);

    }

    private void createDataStructuresTest(){

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        QuestionCategory qc = questionCategoryRepository.findByName("Data structures").get(0);


        Question q = new  Question(qc, "Требуется структура данных для хранения только различных элементов (без дубликатов), при этом она должна поддерживать операции добавления и удаления элементов.\n" +
                "Какая структура данных из перечисленных лучше всего подойдет для этих целей:");
        questions.add(q);
        answers.add(new Answer(q, "множество", true));
        answers.add(new Answer(q,"список", false));
        answers.add(new Answer(q,"хеш-таблица",false));
        answers.add(new Answer(q,"очередь",false));

        q = new  Question(qc, "Если символы 'D', 'C', 'B', 'A' помещены в очередь по порядку и затем будут по одному удалены, в каком порядке это произойдет?");
        questions.add(q);
        answers.add(new Answer(q, "DCBA", true));
        answers.add(new Answer(q,"ABCD", false));
        answers.add(new Answer(q,"DCAB",false));
        answers.add(new Answer(q,"ABDC",false));

        q = new  Question(qc, "При объявлении одномерного массива постоянной длины определяется:");
        questions.add(q);
        answers.add(new Answer(q, "тип элементов, количество элементов, имя массива", true));
        answers.add(new Answer(q,"тип элементов, нижнюю границу массива, верхнюю границу массива, имя массива, шаг для индекса массива", false));
        answers.add(new Answer(q,"тип элементов, нижнюю границу массива, верхнюю границу массива, имя массива, индекс массива",false));
        answers.add(new Answer(q,"тип элементов, имя массива",false));

        q = new  Question(qc, "Какая структура данных позволяет производить вставку и удаление элемента с обоих концов?");
        questions.add(q);
        answers.add(new Answer(q, "дек", true));
        answers.add(new Answer(q,"стек", false));
        answers.add(new Answer(q,"очередь",false));

        q = new  Question(qc, "Какая структура данных соответствует принципу: FIFO?");
        questions.add(q);
        answers.add(new Answer(q, "Очередь", true));
        answers.add(new Answer(q,"Стек", false));
        answers.add(new Answer(q,"B-дерево",false));
        answers.add(new Answer(q,"Односвязные циклические списки",false));

        q = new  Question(qc, "Какая из перечисленных операций более затратна (по времени) для реализации списка через массив относительно реализации через динамически создаваемый связный список?");
        questions.add(q);
        answers.add(new Answer(q, "Вставка", true));
        answers.add(new Answer(q,"Поиск", false));
        answers.add(new Answer(q,"Обход",false));

        q = new  Question(qc, "По какому принципу работает Стек?");
        questions.add(q);
        answers.add(new Answer(q, "LIFO", true));
        answers.add(new Answer(q,"FIFO", false));
        answers.add(new Answer(q,"OIFO",false));
        answers.add(new Answer(q,"Как в очереди",false));


        saveQuestionAnswer(questions,answers);

    }

    private void createDatabasesTest(){

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        QuestionCategory qc = questionCategoryRepository.findByName("Databases").get(0);


        Question q = new  Question(qc, "Какое ключевое слово используется для фильтрации значений, полученных в результате применения агрегирующих функций в результатах запроса с использованием GROUP BY?");
        questions.add(q);
        answers.add(new Answer(q, "HAVING", true));
        answers.add(new Answer(q,"WHERE", false));
        answers.add(new Answer(q,"И WHERE, и HAVING",false));
        answers.add(new Answer(q,"Ни одно из перечисленных",false));

        q = new  Question(qc, "Дана таблица, созданная с помощью SQL-выражения:\n" +
                "CREATE TABLE STUDENTS(\n" +
                " ID INTEGER PRIMARY KEY,\n" +
                " FIRST_NAME VARCHAR(50) NOT NULL,\n" +
                " LAST_NAME VARCHAR(50) NOT NULL,\n" +
                " ADDRESS VARCHAR(100)\n" +
                ")\n" +
                "Какие запросы позволят добавить запись в эту таблицу?");
        questions.add(q);
        answers.add(new Answer(q, "INSERT INTO students VALUES (3, 'Name', 'Surname', NULL);", true));
        answers.add(new Answer(q,"INSERT INTO students(id, first_name) VALUES (2, 'Name');", false));
        answers.add(new Answer(q,"INSERT INTO students VALUES (4, NULL, 'Surname', NULL);",false));

        q = new  Question(qc, "Верно ли логически составлен следующий запрос:\n" +
                "\n\n" +
                "SELECT EMP_NAME, SUM(SAL) FROM EMPLOYEE;");
        questions.add(q);
        answers.add(new Answer(q, "Нет", true));
        answers.add(new Answer(q,"Да", false));

        q = new  Question(qc, "Укажите корректные команды INSERT из перечисленных:");
        questions.add(q);
        answers.add(new Answer(q, "INSERT INTO students (id, first_name, last_name) VALUES (100, 'Kim', 'Matheson')", true));
        answers.add(new Answer(q,"INSERT INTO students (id, first_name, last_name) SELECT id, first_name FROM new_students WHERE last_name IS NULL", false));
        answers.add(new Answer(q,"INSERT INTO students (id, first_name, last_name) (118, 'Ellen', 'Moran')",false));
        answers.add(new Answer(q,"INSERT INTO students (id, first_name, last_name)",false));

        q = new  Question(qc, "Порядок строк в результатах SQL-запроса");
        questions.add(q);
        answers.add(new Answer(q, "может быть возрастающим или убывающим для каждого поля;", true));
        answers.add(new Answer(q,"указывается после ключевого слова SORTED BY;", false));
        answers.add(new Answer(q,"может быть указан только для полей, включенных в список результатов запроса.",false));

        saveQuestionAnswer(questions,answers);

    }




}
