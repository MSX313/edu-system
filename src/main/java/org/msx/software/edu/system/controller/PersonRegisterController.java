//package org.msx.software.edu.system.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.msx.software.edu.system.common.enums.EDUCourseType;
//import org.msx.software.edu.system.common.enums.EDUCurrencyType;
//import org.msx.software.edu.system.common.enums.EDUGenderType;
//import org.msx.software.edu.system.mapper.util.CategoryElementMapper;
//import org.msx.software.edu.system.model.view.util.CategoryElementVm;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/personRegisterController")
//@RequiredArgsConstructor
//public class PersonRegisterController {
//
//    private final PersonMapper personMapper;
//    private final PersistPerson persistPerson;
//    private final CategoryElementMapper categoryElementMapper;
//
//    @PostMapping("/persist")
//    public Object persist(@RequestBody PersonVm personVm) {
//        PersonDto mappedPersonDto = personMapper.map(personVm);
//        PersonDto savedPersonDto = persistPerson.save(mappedPersonDto);
//        return personMapper.map(savedPersonDto);
//    }
//
//    @GetMapping("/getGenderList")
//    public List<CategoryElementVm> getGenderList() {
//        return categoryElementMapper.map(EDUGenderType.class);
//    }
//
//    @GetMapping("/getCourseTypeList")
//    public List<CategoryElementVm> getCourseTypeList() {
//        return categoryElementMapper.map(EDUCourseType.class);
//    }
//
//    @GetMapping("/getCurrencyTypeList")
//    public List<CategoryElementVm> getCurrencyTypeList() {
//        return categoryElementMapper.map(EDUCurrencyType.class);
//    }
//}