package course.spring.mvc.errorhandling.sample4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@Controller
@RequestMapping("/my-entities")
public class MyEntityController {


    @ResponseBody
    @RequestMapping(value = "/{i}",
            produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> find(@PathVariable(name = "i") Long pk) {
        if ((pk % 2) > 0) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"entity\":{ \"pk\":\"" + pk + "\"}}");
        }

        throw new MyEntityNotFoundException();


    }

}
