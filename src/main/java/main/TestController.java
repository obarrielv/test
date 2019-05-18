package main;

import model.Test;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping(method = RequestMethod.POST, value = "/devops")
    public Map testEndPoint(@RequestBody Test model)
    {
        String res = "Hello " +  model.getTo() + " your message will be send";
        return Collections.singletonMap("message", res);
    }
}
