package noticeboard.controllers;

import noticeboard.bo.NoticeBO;
import noticeboard.domain.Notice;
import noticeboard.domain.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/notice")
public class NoticeController {

    @Autowired
    private NoticeBO noticeBO;

    @GetMapping(value = "/getall")
    public ResponseEntity<List<Notice>> getAll() {
        try{

            return ResponseEntity.ok().body(noticeBO.getAll());

        } catch (Exception ex){

            return ResponseEntity.badRequest().body(null);

        }

    }
    @GetMapping(value = "/getlist/{page}")
    public ResponseEntity<List<Notice>> getList(@PathVariable Integer page) {
        try{

            return ResponseEntity.ok().body(noticeBO.getList(page));

        } catch (Exception ex){

            return ResponseEntity.badRequest().body(null);

        }

    }
    @GetMapping(value = "/getbyid/{id}")
    public ResponseEntity<Notice> getAll(@PathVariable Integer id) {
        try {

            return ResponseEntity.ok().body(noticeBO.getById(id));

        } catch (Exception ex){

            return ResponseEntity.badRequest().body(null);
        }

    }

    @PostMapping(value = "/insert", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseObject> insert(@RequestBody Notice notice){
        try{
            notice.setPublishDate(new Date());
            noticeBO.insert(notice);

            ResponseObject obj = new ResponseObject();
            obj.success = true;
            return ResponseEntity.ok().body(obj);
        } catch(Exception ex){
            ResponseObject obj = new ResponseObject();
            obj.success = false;
            return ResponseEntity.badRequest().body(obj);
        }
    }

    @PatchMapping(value = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseObject> update(@RequestBody Notice notice){
        try{
            notice.setViewDate(new Date());
            noticeBO.update(notice);

            ResponseObject obj = new ResponseObject();
            obj.success = true;
            return ResponseEntity.ok().body(obj);

        } catch(Exception ex){
            ResponseObject obj = new ResponseObject();
            obj.success = false;
            return ResponseEntity.badRequest().body(obj);
        }
    }
    @DeleteMapping(value = "/delete/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseObject> delete(@PathVariable Integer id){
        try{

            noticeBO.deleteById(id);

            ResponseObject obj = new ResponseObject();
            obj.success = true;
            return ResponseEntity.ok().body(obj);

        } catch(Exception ex){
            ResponseObject obj = new ResponseObject();
            obj.success = false;
            return ResponseEntity.badRequest().body(obj);
        }
    }
}
