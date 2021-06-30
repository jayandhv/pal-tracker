package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController() {

    }


    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        TimeEntry persistedEntry = timeEntryRepository.create(timeEntry);
        return new ResponseEntity<TimeEntry>(persistedEntry,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable final Long id, @RequestBody final TimeEntry timeEntry) {
        TimeEntry persistedEntry = timeEntryRepository.update(id, timeEntry);
        if(persistedEntry == null)
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<TimeEntry>(persistedEntry,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable Long id) {
        TimeEntry timeEntry = timeEntryRepository.find(id);
        if(timeEntry == null)
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<TimeEntry>(timeEntry,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> timeEntryList = timeEntryRepository.list();
        return new ResponseEntity<List<TimeEntry>>(timeEntryList,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        timeEntryRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
