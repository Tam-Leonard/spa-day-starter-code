package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
        //14.6.3. Rendering the Add User Form
        // In the UserController, create a handler method displayAddUserForm() to render the form.
        // This handler should correspond to the path /user/add, and for now,
        // it can just return the path to the add.html template.
    }
//14.6.4. Processing Form Submission
    //Within the UserController, create a handler method with this signature:
@PostMapping("")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
    //Task 2 of 14.6.4 Check that the verify parameter matches the password within the user object.
    // If it does, render the user/index.html view template with a message that welcomes
    // the user by username. If the passwords don’t match, render the form again
    if (user.getPassword().equals(verify)) {
        return "user/index";
    } else {
        model.addAttribute("error", "You sure about that?");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "user/add";
        }
    //model.addAttribute Task 2 14.6.5
    //If the form is re-rendered when a password is not verified,
    // we should let the user know that their form was not properly submitted.
    // Use model.addAttribute to add an error attribute, letting the user know that their
    // passwords should match. This model attribute will need to correspond
    // to an element in the template that will only render the error text when the
    // passwords do not match.

    //Task 3 14.6.5 the two additional model.addAttributes
    /*If we send a user back to re-populate the form, it would be nice to not clear their previous submission.
    We won’t need to save the password entries in this fashion.
    In the form submission handler, add the username and email fields of the submitted user as model attributes.
    Back in the form, add a value attribute to these form fields and make them equal to the model attributes

    Then added th:value to the add.html page for email and username*/
    }

}
