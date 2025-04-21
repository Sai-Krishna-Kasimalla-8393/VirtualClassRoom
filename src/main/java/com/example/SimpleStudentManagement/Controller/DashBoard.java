package com.example.SimpleStudentManagement.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.SimpleStudentManagement.Model.Assignment;
import com.example.SimpleStudentManagement.Model.Attendance;
import com.example.SimpleStudentManagement.Model.Courses;
import com.example.SimpleStudentManagement.Model.CreateClass;
import com.example.SimpleStudentManagement.Model.Fee;
import com.example.SimpleStudentManagement.Model.JoinCourse;
import com.example.SimpleStudentManagement.Model.Marks;
import com.example.SimpleStudentManagement.Model.Staff_Login;
import com.example.SimpleStudentManagement.Model.Staff_Signup;
import com.example.SimpleStudentManagement.Model.Student_Login;
import com.example.SimpleStudentManagement.Model.Student_Signup;
import com.example.SimpleStudentManagement.Repository.AssignmentRepository;
import com.example.SimpleStudentManagement.Repository.AttendanceRepository;
import com.example.SimpleStudentManagement.Repository.CourseRepository;
import com.example.SimpleStudentManagement.Repository.CreateClassRepository;
import com.example.SimpleStudentManagement.Repository.FeeRepository;
import com.example.SimpleStudentManagement.Repository.JoinCourseRepository;
import com.example.SimpleStudentManagement.Repository.MarksRepository;
import com.example.SimpleStudentManagement.Repository.Staff_Signup_Repository;
import com.example.SimpleStudentManagement.Repository.Student_Signup_Repository;


import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/dashboard")
public class DashBoard {

    @Autowired
    private Staff_Signup_Repository repoStaff;

    @Autowired
    private Student_Signup_Repository repoStudent;
    
    @Autowired
    private CreateClassRepository  ClassRepository;
    
   
   @Autowired
    private  MarksRepository repo;
    
    @Autowired
    private MarksRepository marksrepo;
    
  @Autowired
  private AssignmentRepository assrepo;
  
  @Autowired
  private AttendanceRepository attendrepo;
  
  @Autowired
  private CourseRepository courserepo;
  @Autowired
  private FeeRepository feeRepo;
  
  @Autowired JoinCourseRepository joinrepo;
    @GetMapping()
    public String dashboard() {
        return "Index";
    }

    // ================= STAFF ===================

    @GetMapping("/staff/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("staff", new Staff_Signup());
        return "Staff_Signup";
    }

    @PostMapping("/staff/signup")
    public String saveStaff(@ModelAttribute Staff_Signup staff) {
        repoStaff.save(staff);
        return "redirect:/dashboard";
    }

    @GetMapping("/staff/login")
    public String showLoginForm(Model model) {
        model.addAttribute("staff", new Staff_Login());
        return "Staff_Login";
    }

    @PostMapping("/staff/login")
    public String processLogin(@ModelAttribute Staff_Login loginForm, Model model, HttpSession session) {
        Staff_Signup staff = repoStaff.findByEmailAndPassword(
                loginForm.getEmail(), loginForm.getPassword());

        if (staff != null) {
            session.setAttribute("staffName", staff.getFirstName());
            return "redirect:/dashboard/staff/sdashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            model.addAttribute("staff", new Staff_Login());
            return "Staff_Login";
        }
    }

    @GetMapping("/staff/sdashboard")
    public String staffDashboard(HttpSession session, Model model) {
        String staffName = (String) session.getAttribute("staffName");
        model.addAttribute("staffName", staffName);
        return "Staff_Dashboard";
    }
    
    @GetMapping("/stafflogout")
    public String s_Logout() {
    	return "redirect:/dashboard";
    }
    // ================= STUDENT ===================

    @GetMapping("/student/signup")
    public String studentSignup(Model model) {
        model.addAttribute("student", new Student_Signup());
        return "student_signup";
    }

    @PostMapping("/student/signup")
    public String saveStudent(@ModelAttribute Student_Signup student) {
        repoStudent.save(student);
        return "redirect:/dashboard";
    }

    @GetMapping("/student/login")
    public String studentLogin(Model model) {
        model.addAttribute("student", new Student_Login());
        return "student_Login";
    }

    @PostMapping("/student/login")
    public String studentLoginValidation(@ModelAttribute Student_Login login, Model model, HttpSession session) {
        Student_Signup stu = repoStudent.findByEmailAndPassword(
                login.getEmail(), login.getPassword());

        if (stu != null) {
            session.setAttribute("studentName", stu.getFirstName());
            session.setAttribute("studentId", stu.getStudentId());
            return "redirect:/dashboard/student/stdashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            model.addAttribute("student", new Student_Login());
            return "student_Login";
        }
    }

    @GetMapping("/student/stdashboard")
    public String studentDashboard(HttpSession session, Model model) {
        String studentName = (String) session.getAttribute("studentName");
        model.addAttribute("studentName", studentName);
        return "Student_Dashboard";
    }
    
    @GetMapping("/studentlogout")
    public String Student_Logout() {
		return "redirect:/dashboard";
    	
    }
    
    
    @GetMapping("/setcourses")
    public String setcourses(Model model) {
    	model.addAttribute("course",new Courses());
    	return "course";
    }
    
    @PostMapping("/setcourses")
    public String savecourses(@ModelAttribute Courses course) {
    	courserepo.save(course);
		return "redirect:/dashboard/staff/sdashboard";
    	
    }
    
    @GetMapping("/fetchcourse")
    public String fetchcourse(Model model) {
    	model.addAttribute("fetchcourse",courserepo.findAll());
    	return "fetchcourse";
    }
    
    @GetMapping("/joincourse")
    public String joincourse(Model model) {
    	model.addAttribute("joincourse",new JoinCourse());
    	return "joincourse";
    }
    
    @PostMapping("/joincourse")
    public String savejoincourse(@ModelAttribute JoinCourse join) {
    	joinrepo.save(join);
    	return "redirect:/dashboard/student/stdashboard";
    	
    }
    
    
    
    @GetMapping("/staff/create-class")
    public String showCreateClassForm(Model model) {
        model.addAttribute("virtualClass", new CreateClass());
        return "createstudent";
    }

    @PostMapping("/staff/create-class")
    public String submitClassForm(@ModelAttribute CreateClass virtualClass) {
        virtualClass.setCreatedAt(LocalDateTime.now());
        virtualClass.setUpdatedAt(LocalDateTime.now());
        ClassRepository.save(virtualClass);
        return "redirect:/dashboard/staff/sdashboard";
    }
    
    @GetMapping("/staff/fetch-class")
    public String fetchClass(Model model) {
        model.addAttribute("classes", ClassRepository.findAll());
        return "fetch_classes"; 
    }
    
    @GetMapping("/student/fetch-class")
    public String fetchClasss(Model model) {
        model.addAttribute("classes", ClassRepository.findAll());
        return "fetch_classes"; 
    }
    
   
    

    
    
    @GetMapping("/student/marks")
    public String SetGrades(Model model) {
    	model.addAttribute("mark",new Marks());
    	return "marks";
    }
     
    @PostMapping("/student/marks")
    public String saveGrades(@ModelAttribute Marks mark, HttpSession session){
        Integer studentId = (Integer) session.getAttribute("StudentId");

        if (studentId != null) {
//            mark.setStudentId(studentId);  
            marksrepo.save(mark);
        }
        return "redirect:/dashboard/student/stdashboard";
    }
    
    @GetMapping("/student/getmarks")
    public String getMarks(HttpSession session, Model model) {
        Integer stuId = (Integer) session.getAttribute("studentId");
        if (stuId == null) {
            return "redirect:/dashboard/student/login";
        }

        List<Marks> markList = repo.findByStudentId(stuId);

        if (!markList.isEmpty()) {
            Marks m = markList.get(0); 
            int totalSubjects = 7;
            float totalMarks = m.getCoreJava() + m.getJdbc() + m.getHibernateJpa() +
                               m.getSpringMvc() + m.getRestApi() + m.getMySQl() + m.getDevops();
            float sgpa = totalMarks / totalSubjects;
            m.setSGPA(sgpa);
            String grade;
            if (sgpa >= 90) grade = "A+";
            else if (sgpa >= 80) grade = "A";
            else if (sgpa >= 70) grade = "B";
            else if (sgpa >= 60) grade = "C";
            else if (sgpa >= 50) grade = "D";
            else grade = "F";

            m.setGrade(grade);
            repo.save(m); 
        }

        model.addAttribute("mark", markList.get(0));
        return "fetchMarks";
    }
    
    
    
    @GetMapping("/student/assignments")
    public String setAssignment(Model model) {
    	model.addAttribute("assign",new Assignment());
    	return "assignment";
    }
    
    @PostMapping("/student/assignments")
    public String saveAssignment(@ModelAttribute Assignment ass) {
    	assrepo.save(ass);
		return "redirect:/dashboard/staff/sdashboard";
    	
    }
    
    @GetMapping("/student/fetchassignment")
    public String fetchassign(Model model) {
    	model.addAttribute("assigns",assrepo.findAll());
    	return "fetchassignment";
    }
    
    @GetMapping("/staff/attendance")
    public String setAttendance(Model model) {
    	model.addAttribute("attend",new Attendance());
    	return "Attendance";
    	
    }
    
    @PostMapping("/staff/attendance")
    public String saveAttendance(@ModelAttribute Attendance attend) {
    	attendrepo.save(attend);
    	return "redirect:/dashboard/staff/sdashboard";
    	
    }

    @GetMapping("/student/getAttendance")
    public String getAttendance(HttpSession session, Model model) {
        Integer stuId = (Integer) session.getAttribute("studentId");
        if (stuId == null) {
            return "redirect:/dashboard/student/login";
        }

        List<Attendance> attends = attendrepo.findByStudentId(stuId);

        model.addAttribute("attends", attends);
        if (!attends.isEmpty()) {
            model.addAttribute("firstAttendance", attends.get(0));
        }

        return "getattendance";
    }

    
    
    @GetMapping("/students/Fee")
    public String setFee(Model model) {
    	model.addAttribute("fee",new Fee());
    	return "Fees";
    }
    
    @PostMapping("/students/Fee")
    public String payFee(@ModelAttribute Fee fee) {
    	feeRepo.save(fee);
    	return "redirect:/dashboard/staff/sdashboard";
    }
    
    @GetMapping("/students/fetchFee")
    public String fetchFee(HttpSession session,Model model) {
    	Integer stuId=(Integer)session.getAttribute("studentId");
    	if(stuId==null) {
    		return "redirect:/dashboard/student/login";
    	}
    	List<Fee> fees=feeRepo.findByStudentId(stuId);
    	model.addAttribute("fees",fees);
    	return "fetchFee";
    }
    @GetMapping("/mycourses")
    public String myCourse(HttpSession session ,Model model) {
    	Integer stuId=(Integer)session.getAttribute("studentId");
    	if(stuId==null) {
    		return "redirect:/dashboard/student/login";
    	}
    	List<JoinCourse> mycourse=joinrepo.findByStudentid(stuId);
    	model.addAttribute("mycourse",mycourse);
    	return "fetchmycourse";
    }
}
