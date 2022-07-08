package com.example.soft_cons.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.example.soft_cons.exception.ResourceNotFoundException;
import com.example.soft_cons.model.TimeTable;
import com.example.soft_cons.repository.TimeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class TimeTableController {
    @Autowired
    private TimeTableRepository timetableRepository;

    @GetMapping("/timetables")
    public List<TimeTable> getAllTimeTables() {
        return timetableRepository.findAll();
    }

    @GetMapping("/timetables/{id}")
    public ResponseEntity<TimeTable> getTimeTableById(@PathVariable(value = "id") Long timetableId)
            throws ResourceNotFoundException {
        TimeTable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() -> new ResourceNotFoundException("TimeTable not found for this id :: " + timetableId));
        return ResponseEntity.ok().body(timetable);
    }

    @PostMapping("/timetables")
    public TimeTable createTimeTable(@Valid @RequestBody TimeTable timetable) {
        return timetableRepository.save(timetable);
    }

    @PutMapping("/timetables/{id}")
    public ResponseEntity<TimeTable> updateTimeTable(@PathVariable(value = "id") Long timetableId,
                                             @Valid @RequestBody TimeTable timetableDetails) throws ResourceNotFoundException {
        TimeTable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() -> new ResourceNotFoundException("TimeTable not found for this id :: " + timetableId));

        timetable.setSemester(timetableDetails.getSemester());
        timetable.setTitle(timetableDetails.getTitle());
        final TimeTable updatedTimeTable = timetableRepository.save(timetable);
        return ResponseEntity.ok(updatedTimeTable);
    }

    @DeleteMapping("/timetables/{id}")
    public Map<String, Boolean> deleteTimeTable(@PathVariable(value = "id") Long timetableId)
            throws ResourceNotFoundException {
        TimeTable timetable = timetableRepository.findById(timetableId)
                .orElseThrow(() -> new ResourceNotFoundException("TimeTable not found for this id :: " + timetableId));

        timetableRepository.delete(timetable);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}