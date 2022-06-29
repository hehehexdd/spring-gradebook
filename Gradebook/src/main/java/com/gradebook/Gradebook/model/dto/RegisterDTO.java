package com.gradebook.Gradebook.model.dto;

import com.gradebook.Gradebook.model.entity.RoleType;
import com.gradebook.Gradebook.model.entity.SClass;

public class RegisterDTO {

    private String username;
    private String email;
    private String password;
    private String address;
    private String name;
    private String firstName;
    private String lastName;
    private Long directorId;
    private Long schoolId;
    private Long classId;
    private SClass sClass;
    private RoleType role;
    private boolean isAccountLocked;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, String email, String password, String firstName, String lastName, RoleType role, boolean isAccountLocked, Long schoolId, Long classId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolId = schoolId;
        this.classId = classId;
        this.isAccountLocked = isAccountLocked;
        this.role = role;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public SClass getsClass() {
        return sClass;
    }

    public void setsClass(SClass sClass) {
        this.sClass = sClass;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public boolean isAccountLocked() {
        return isAccountLocked;
    }

    public void setAccountLocked(boolean accountLocked) {
        isAccountLocked = accountLocked;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}
