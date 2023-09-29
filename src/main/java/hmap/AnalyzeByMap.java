package hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0.0;
        double subjects = 0.0;
        for (Pupil pupil : pupils) {
            subjects += pupils.size();
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
        }
        return sumScore / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScore = 0.0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            Label label = new Label(pupil.name(), sumScore / pupil.subjects().size());
            labels.add(label);
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> map2 : map.entrySet()) {
            Label label = new Label(map2.getKey(), (double) map2.getValue() / pupils.size());
            labels.add(label);
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sumScore = 0.0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            Label label = new Label(pupil.name(), sumScore);
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> map2 : map.entrySet()) {
            Label label = new Label(map2.getKey(), (double) map2.getValue());
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}