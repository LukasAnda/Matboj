package sk.lukasanda.matboj.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
open class Base(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                var id: Long = 0)

@Entity
@Table(name = "team")
data class Team(
        var name: String = "",
        @OneToMany(
                mappedBy = "team",
                cascade = arrayOf(CascadeType.ALL),
                fetch = FetchType.LAZY
        )
        @JsonManagedReference
        var players: MutableList<Player> = mutableListOf(),

        @OneToMany(
                mappedBy = "team",
                cascade = arrayOf(CascadeType.ALL),
                fetch = FetchType.LAZY
        )
        @JsonManagedReference
        var teamProblems: MutableList<TeamProblem> = mutableListOf(),

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "school_id")
        @JsonBackReference
        var school: School? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "category_id")
        @JsonBackReference
        var category: Category? = null


) : Base()


@Entity
@Table(name = "player")
data class Player(
        var firstName: String = "",
        var lastName: String = "",
        var email: String = "",
        var phone: String = "",
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "team_id")
        @JsonBackReference
        var team: Team? = null,
        var barcode: String = ""
) : Base()

@Entity
@Table(name = "school")
data class School(
        var name: String = "",
        var category: String = "",
        var teacherName: String = "",
        var teacherEmail: String = "",
        var teacherPhone: String = "",
        var schoolAddress: String = "",
        @OneToMany(
                mappedBy = "school",
                cascade = arrayOf(CascadeType.ALL),
                fetch = FetchType.LAZY
        )
        @JsonManagedReference
        var teams: MutableList<Team> = mutableListOf()
) : Base()

@Entity
@Table(name = "category")
data class Category(
        var name: String = "",

        @OneToMany(
                mappedBy = "category",
                cascade = arrayOf(CascadeType.ALL),
                fetch = FetchType.LAZY
        )
        @JsonManagedReference
        var teams: MutableList<Team> = mutableListOf()
) : Base()

@Entity
@Table(name = "problem")
data class Problem(
        var name: String = "",
        var image: String = "",
        var statement: String = "",
        var solution: String = "",
        var points: Int = 0,
        @OneToMany(
                mappedBy = "problem",
                cascade = arrayOf(CascadeType.ALL),
                fetch = FetchType.LAZY
        )
        @JsonManagedReference
        var teamProblems: MutableList<TeamProblem> = mutableListOf()
) : Base()

@Entity
@Table(name = "team_problem")
data class TeamProblem(
        var state: String = "",
        var extraPoints: Int = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "team_id")
        @JsonBackReference
        var team: Team? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "problem_id")
        @JsonBackReference
        var problem: Problem? = null

) : Base()

