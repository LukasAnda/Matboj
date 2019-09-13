package sk.lukasanda.matboj.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sk.lukasanda.matboj.entities.Player
import sk.lukasanda.matboj.entities.School
import sk.lukasanda.matboj.entities.Team
import sk.lukasanda.matboj.repositories.SchoolRepository
import sk.lukasanda.matboj.repositories.TeamRepository

@RestController
@RequestMapping("/")
class ExampleController {
    @Autowired
    lateinit var repository: SchoolRepository

    @GetMapping("/hello")
    fun example(): School {
        return repository.findAll().first()
    }

    @GetMapping("/insert")
    fun insert() {
        repository.deleteAll()
        val player = Player("Jozko", "Mrkvicka", "jozko.mrkvicka@gmail.com", "12345", barcode = "barcode")
        val player2 = Player("Ferko", "Mrkvicka", "Ferko.mrkvicka@gmail.com", "12345", barcode = "barcode")
        val player3 = Player("Janko", "Mrkvicka", "janko.mrkvicka@gmail.com", "sdfs", barcode = "barcode")
        val player4 = Player("Dezko", "Mrkvicka", "dezko.mrkvicka@gmail.com", "12345", barcode = "barcode")

        val team = Team("Team 1", mutableListOf(player, player2, player3, player4))
        player.team = team
        player2.team = team
        player3.team = team
        player4.team = team

        val school = School(teams = mutableListOf(team, team))
        team.school = school

        repository.save(school)
    }
}