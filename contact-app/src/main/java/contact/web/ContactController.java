package contact.web;

import contact.application.ContactService;
import contact.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ContactController {
    
    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }
       
    @RequestMapping(method=RequestMethod.GET)
    public String home(Map<String, Object> model) {
        List<Contact> contacts = service.findAll();
        model.put("contacts", contacts);
        return "home";
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public String submit(Contact contact) {
        service.save(contact);
        return "redirect:/";
  }
}
