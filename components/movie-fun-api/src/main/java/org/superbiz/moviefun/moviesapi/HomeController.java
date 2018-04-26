package org.superbiz.moviefun.moviesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MoviesClient moviesClient;
    private final AlbumsClient albumsClient;
    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

    public HomeController(MoviesClient moviesClient, AlbumsClient albumsClient, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
        this.moviesClient = moviesClient;
        this.albumsClient = albumsClient;
        this.movieFixtures = movieFixtures;
        this.albumFixtures = albumFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesClient.addMovie(movie);
        }

        for (AlbumInfo album : albumFixtures.load()) {
            albumsClient.addAlbum(album);
        }

        model.put("movies", moviesClient.getMovies());
        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }

    @GetMapping("/setup2")
    public String setup2(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesClient.addMovie(movie);
        }
        model.put("movies", moviesClient.getMovies());
        return "setup";
    }

    @GetMapping("/setup3")
    public String setup3(Map<String, Object> model) {
        logger.error("&&&&&&&&&&&&&&&&&&&&&&&&&&&& albumFixtures"+albumFixtures.toString());
        logger.error("&&&&&&&&&&&&&&&&&&&&&&&&&&&& albumsClient"+albumsClient.toString());
        logger.error("######################################### albumfixture load"+albumFixtures.load().size());

        for (AlbumInfo album : albumFixtures.load()) {
            albumsClient.addAlbum(album);

        }
        logger.error("######################################### albumClient getAlbums"+albumsClient.getAlbums().size());


        model.put("albums", albumsClient.getAlbums());

        return "setup";
    }
}
