package car.car1.data;

import car.car1.Order;
import car.car1.RegistrationForm;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import car.car1.Information;
import car.car1.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class car1Client {


    //
    // GET examples
    //


//     * Specify parameter as varargs argument
//     * Alternate implementations...
//     * The next three methods are alternative implementations of
//     * getIngredientById() as shown in chapter 6. If you'd like to try
//     * any of them out, comment out the previous method and uncomment
//     * the variant you want to use.
//     */

    /*
     * Specify parameters with a map
     */
    // public Ingredient getIngredientById(String ingredientId) {
    //   Map<String, String> urlVariables = new HashMap<>();
    //   urlVariables.put("id", ingredientId);
    //   return rest.getForObject("http://localhost:8080/ingredients/{id}",
    //       Ingredient.class, urlVariables);
    // }

    /*
     * Request with URI instead of String
     */
    // public Ingredient getIngredientById(String ingredientId) {
    //   Map<String, String> urlVariables = new HashMap<>();
    //   urlVariables.put("id", ingredientId);
    //   URI url = UriComponentsBuilder
    //             .fromHttpUrl("http://localhost:8080/ingredients/{id}")
    //             .build(urlVariables);
    //   return rest.getForObject(url, Ingredient.class);
    // }

    /*
     * Use getForEntity() instead of getForObject()
     */
    // public Ingredient getIngredientById(String ingredientId) {
    //   ResponseEntity<Ingredient> responseEntity =
    //       rest.getForEntity("http://localhost:8080/ingredients/{id}",
    //           Ingredient.class, ingredientId);
    //   log.info("Fetched time: " +
    //           responseEntity.getHeaders().getDate());
    //   return responseEntity.getBody();
    // }

    public List<Information> getAllBookings() {
        try {
            RestTemplate rest = new RestTemplate();

            return rest.exchange("http://localhost:8081/bookings",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Information>>() {})
                    .getBody();
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }



    public Information saveBooking(Information information) {
        try {
            RestTemplate rest = new RestTemplate();
            rest.postForObject("http://localhost:8081/addOrder",
                    information, Information.class);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public Information savePayment(Order order) {
        try {
            RestTemplate rest = new RestTemplate();
            rest.postForObject("http://localhost:8083/addPayment",
                    order, Order.class);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

//    public List<User> getAllUsers() {
//        try {
//            RestTemplate rest = new RestTemplate();
//
//            return rest.exchange("http://localhost:8080/users",
//                    HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
//                    })
//                    .getBody();
//        } catch (Exception e) {
//            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void saveUser(RegistrationForm user) {
        try {
            RestTemplate rest = new RestTemplate();
            rest.postForObject("http://localhost:8080/register",
                    user, User.class);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public User getUserByUsername(String username)  {
        try {
            RestTemplate rest = new RestTemplate();
            Map<String, String> urlVariables = new HashMap<>();
            urlVariables.put("username", username);
            return rest.getForObject("http://localhost:8080/user/{username}",
                    User.class, urlVariables);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public Information deleteById(int id)  {
        try {
            RestTemplate rest = new RestTemplate();
            Map<String, Integer> urlVariables = new HashMap<>();
            urlVariables.put("id", id);
            return rest.getForObject("http://localhost:8080/delete/{id}",
                    Information.class, urlVariables);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public Information findById(int id)  {
        try {
            RestTemplate rest = new RestTemplate();
            Map<String, Integer> urlVariables = new HashMap<>();
            urlVariables.put("id", id);
            return rest.getForObject("http://localhost:8080/edit/{id}",
                    Information.class, urlVariables);
        } catch (Exception e) {
            System.err.println("Exception in TacoCloudClient: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
//  public User getUserByUsername() {
//    RestTemplate rest = new RestTemplate();
//
//    return rest.exchange("/user/{username}",
//            HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>() {})
//        .getBody();
//  }

    //
    // PUT examples
    //

//  public void updateIngredient(Ingredient ingredient) {
//    rest.put("http://localhost:8080/ingredients/{id}",
//          ingredient, ingredient.getId());
//  }
//
//  //
//  // POST examples
//  //
//  public Ingredient createIngredient(Ingredient ingredient) {
//    return rest.postForObject("http://localhost:8080/ingredients",
//        ingredient, Ingredient.class);
//  }
//
//  /*
//   * Alternate implementations...
//   * The next two methods are alternative implementations of
//   * createIngredient() as shown in chapter 6. If you'd like to try
//   * any of them out, comment out the previous method and uncomment
//   * the variant you want to use.
//   */
//
//  // public URI createIngredient(Ingredient ingredient) {
//  //   return rest.postForLocation("http://localhost:8080/ingredients",
//  //       ingredient, Ingredient.class);
//  // }
//
//  // public Ingredient createIngredient(Ingredient ingredient) {
//  //   ResponseEntity<Ingredient> responseEntity =
//  //          rest.postForEntity("http://localhost:8080/ingredients",
//  //                             ingredient,
//  //                             Ingredient.class);
//  //   log.info("New resource created at " +
//  //            responseEntity.getHeaders().getLocation());
//  //   return responseEntity.getBody();
//  // }
//
//  //
//  // DELETE examples
//  //
//
//  public void deleteIngredient(Ingredient ingredient) {
//    rest.delete("http://localhost:8080/ingredients/{id}",
//        ingredient.getId());
//  }
//
//  //
//  // Traverson with RestTemplate examples
//  //
//
//  public Iterable<Ingredient> getAllIngredientsWithTraverson() {
//    ParameterizedTypeReference<Resources<Ingredient>> ingredientType =
//        new ParameterizedTypeReference<Resources<Ingredient>>() {};
//
//    Resources<Ingredient> ingredientRes =
//        traverson
//          .follow("ingredients")
//          .toObject(ingredientType);
//
//    Collection<Ingredient> ingredients = ingredientRes.getContent();
//
//    return ingredients;
//  }
//
//  public Ingredient addIngredient(Ingredient ingredient) {
//    String ingredientsUrl = traverson
//        .follow("ingredients")
//        .asLink()
//        .getHref();
//    return rest.postForObject(ingredientsUrl,
//                              ingredient,
//                              Ingredient.class);
//  }
//
//

}
