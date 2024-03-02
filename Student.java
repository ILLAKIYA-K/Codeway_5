import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.getCapacity() > 0) {
            registeredCourses.add(course);
            course.setCapacity(course.getCapacity() - 1);
            System.out.println(name + " registered for course: " + course.getTitle());
        } else {
            System.out.println("Sorry, " + course.getTitle() + " is already full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.setCapacity(course.getCapacity() + 1);
            System.out.println(name + " dropped course: " + course.getTitle());
        } else {
            System.out.println(name + " is not registered for " + course.getTitle());
        }
    }

    public void displayRegisteredCourses() {
        System.out.println("Registered courses for " + name + ":");
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle());
        }
    }
}
