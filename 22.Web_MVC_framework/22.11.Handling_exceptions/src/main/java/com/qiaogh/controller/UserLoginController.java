package com.qiaogh.controller;

import com.qiaogh.domain.User;
import com.qiaogh.service.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.File;
import java.net.URLDecoder;

@Controller
public class UserLoginController {

    private UserService userService;

    @ModelAttribute
    public User user() {
        return new User();
    }

    @RequestMapping( value = "/login", method = RequestMethod.GET )
    public String login() {
        return "enroll";
    }

    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public String login( @RequestParam( "portrait" ) MultipartFile portrait, @Valid User user, BindingResult errors, ModelMap modelMap ) throws Exception {
        File file = new File( buildFileName( portrait ) );
        portrait.transferTo( file );
        if ( errors.hasErrors() ) {
            return "enroll";
        }
        User persistUser = userService.getByName( user.getName() );

        if ( persistUser.getPassword().equals( user.getPassword() ) ) {
            modelMap.addAttribute( "user", persistUser );
            modelMap.addAttribute( "fileNames", loadFileNames() );
            return "success";
        }
        return "error";
    }

    @RequestMapping( "/download" )
    public ResponseEntity<byte[]> download( @RequestParam String fileName ) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_OCTET_STREAM );
        headers.setContentDispositionFormData( "attachment", fileName );
        File file = new File( buildFileName( fileName ) );
        return new ResponseEntity<>( FileUtils.readFileToByteArray( file ), headers, HttpStatus.CREATED );
    }

    private String[] loadFileNames() throws Exception {
        File portraitsDir = new File( getPortraitsDirPath() );
        return portraitsDir.list();
    }

    private String buildFileName( MultipartFile portrait ) throws Exception {
        String originalFilename = portrait.getOriginalFilename();
        return buildFileName( originalFilename );
    }

    private String buildFileName( String fileName ) throws Exception {
        return getPortraitsDirPath() + "/" + fileName;
    }

    private String getPortraitsDirPath() throws Exception {
        String portraitsDir = URLDecoder.decode( UserLoginController.class.getResource( "/portraits" ).toString(), "UTF-8" );
        return portraitsDir.substring( 5 );
    }

    @ExceptionHandler( Exception.class )
    public String exception( Exception e, Model model ) {
        model.addAttribute( "e", e );
        return "exception";
    }

    @Autowired
    public void setUserService( UserService userService ) {
        this.userService = userService;
    }
}
