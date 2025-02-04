package com.lcwd.user.service.services.impl;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exception.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiseImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
/*
    @Autowired
    private HttpMessageConverter httpMessageConverter;*/
    private Logger logger = LoggerFactory.getLogger(UserServiseImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() { // need to implemet
        List<User> allUsers = userRepository.findAll();
        //implement RATING SERVICE CALL: USING REST TEMPLATE
        //http://localhost:8083/ratings
        String url = "http://localhost:8083/ratings";
        ArrayList<Rating> ratingsOfAllUsers = restTemplate.getForObject(url, ArrayList.class);


        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with give id is not found on server !! " + userId));
        //fetch rating for the above user from the RATING SERVICE
        String ratingUrl = "http://RATINGSSERVICE/ratings/users/"+user.getUserId();
        Rating[] ratingsOfUser = restTemplate.getForObject(ratingUrl, Rating[].class);
        logger.info("{}", ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();


        /*ResponseEntity<Ratings[]> responseEntity = restTemplate.getForEntity(url, Ratings[].class);
        Ratings[] responseBody = responseEntity.getBody();
        List<Ratings> allRatings = Arrays.asList(responseBody);*/

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
            //localhost:8082/hotels/b696c519-f421-4902-a520-2ffdbd0a0f8f
            String hotelUrl = "http://HOTELSERVICE/hotels/"+rating.getHotelId();
            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(hotelUrl, Hotel.class);
            Hotel hotel = forEntity.getBody();
            logger.info("Response status code : {} ",forEntity.getStatusCode());
            //set the hotel to rating
            rating.setHotel(hotel);
            //return the rating
            return rating;

        }).collect(Collectors.toList());

        //user.setRatings(ratingsOfUser);
        user.setRatings(ratingList);
        return user;
    }
    /*httpMessageConverter.canRead()

        restTemplate.setMessageConverters(getJsonMessageConverters());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<>(headers);


        ResponseEntity<List<User>> response = restTemplate.exchange(url, HttpMethod.GET,
                entity,new ParameterizedTypeReference<List<User>>() {});*/

    /*private List<HttpMessageConverter<?>> getJsonMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }*/

    /*private List<HttpMessageConverter<?>> getXmlMessageConverters() {
        XStreamMarshaller marshaller = new XStreamMarshaller();
        marshaller.setAnnotatedClasses(Foo.class);
        MarshallingHttpMessageConverter marshallingConverter =
                new MarshallingHttpMessageConverter(marshaller);

        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(marshallingConverter);
        return converters;
    }*/
}

//I did mistake in implementation part, now it resolved. thanks Durgesh
//https://stackoverflow.com/questions/76403515/com-fasterxml-jackson-databind-exc-mismatchedinputexception-cannot-deserialize

