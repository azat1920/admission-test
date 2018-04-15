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


        //--------------------------------------------------

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

        QuestionCategory qc_2 = questionCategoryRepository.findByName("Linux").get(0);
        Question q2 = new Question(qc_2, "Что выведет команда \"echo 1+1\"");
        answers.add(new Answer(q2, "2",false));
        answers.add(new Answer(q2, "1+1",true));



        saveQuestionAnswer(questions,answers);

    }

    private void createWebTest(){

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        saveQuestionAnswer(questions,answers);

    }

    private void createDataStructuresTest(){

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        saveQuestionAnswer(questions,answers);

    }

    private void createDatabasesTest(){

        List<Question> questions = new ArrayList<>();
        List<Answer> answers = new ArrayList<>();

        saveQuestionAnswer(questions,answers);

    }




}
