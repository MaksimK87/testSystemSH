package by.htp.spring.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "tests")
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private int id;
    @Column(name = "test_name")
    private String testName;
    @Column(name = "duration_time")
    private int testDuration;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "test", cascade = {CascadeType.ALL})
    private List<Questions> questions;


    public Test() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTestDuration() {
        return testDuration;
    }

    public void setTestDuration(int testDuration) {
        this.testDuration = testDuration;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                ", testDuration=" + testDuration +
                ", questions=" + questions +
                '}';
    }



    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return id == test.id &&
                testDuration == test.testDuration &&
                RightAnswer == test.RightAnswer &&
                testName.equals(test.testName) &&
                questionText.equals(test.questionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, testName, testDuration, questionText, RightAnswer);
    }*/
}
