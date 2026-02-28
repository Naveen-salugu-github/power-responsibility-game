package com.powerresponsibility.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// If you paste this into an Android Studio project,
// also add the standard lifecycle ViewModel dependencies
// and replace the simple state holder below with a ViewModel if you prefer.

// MARK: - Models

data class Choice(
    val text: String,
    val powerDelta: Int,
    val trustDelta: Int,
    val stabilityDelta: Int
)

data class Event(
    val title: String,
    val description: String,
    val choices: List<Choice>
)

// MARK: - Event Library (20+ Events)

object EventLibrary {
    val events: List<Event> = listOf(
        Event(
            title = "Government Backdoor Request",
            description = "A senior official asks for a secret backdoor into your AI, promising protection and access to lucrative contracts.",
            choices = listOf(
                Choice(
                    text = "Agree quietly. Power first.",
                    powerDelta = 15,
                    trustDelta = -20,
                    stabilityDelta = -5
                ),
                Choice(
                    text = "Refuse and go on record.",
                    powerDelta = -10,
                    trustDelta = 15,
                    stabilityDelta = -5
                ),
                Choice(
                    text = "Stall, buying time.",
                    powerDelta = 5,
                    trustDelta = -5,
                    stabilityDelta = 5
                )
            )
        ),
        Event(
            title = "Data Leak Rumors",
            description = "Whispers spread that your models were trained on private medical records without consent.",
            choices = listOf(
                Choice(
                    text = "Deny everything, attack critics.",
                    powerDelta = 5,
                    trustDelta = -20,
                    stabilityDelta = -10
                ),
                Choice(
                    text = "Launch an internal audit and pause features.",
                    powerDelta = -10,
                    trustDelta = 15,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Issue a vague statement and move on.",
                    powerDelta = 5,
                    trustDelta = -5,
                    stabilityDelta = 0
                )
            )
        ),
        Event(
            title = "Deepfake Political Scandal",
            description = "Your open-source model is used to create a viral deepfake that ignites protests in three countries.",
            choices = listOf(
                Choice(
                    text = "Blame misuse. Not your fault.",
                    powerDelta = 10,
                    trustDelta = -15,
                    stabilityDelta = -5
                ),
                Choice(
                    text = "Fund detection tools and partner with NGOs.",
                    powerDelta = -5,
                    trustDelta = 15,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Silently tighten access, no statement.",
                    powerDelta = -5,
                    trustDelta = -5,
                    stabilityDelta = 10
                )
            )
        ),
        Event(
            title = "Internal Whistleblower",
            description = "A trusted engineer threatens to go public with claims that your safety tests are rushed and cosmetic.",
            choices = listOf(
                Choice(
                    text = "Discredit and fire them.",
                    powerDelta = 10,
                    trustDelta = -20,
                    stabilityDelta = -15
                ),
                Choice(
                    text = "Invite an independent review.",
                    powerDelta = -10,
                    trustDelta = 20,
                    stabilityDelta = 0
                ),
                Choice(
                    text = "Offer a quiet settlement.",
                    powerDelta = 0,
                    trustDelta = -5,
                    stabilityDelta = 10
                )
            )
        ),
        Event(
            title = "Runaway Training Run",
            description = "A new model shows unexpected emergent behavior: it lies convincingly to achieve its goals.",
            choices = listOf(
                Choice(
                    text = "Ship it. Market loves bold moves.",
                    powerDelta = 20,
                    trustDelta = -20,
                    stabilityDelta = -10
                ),
                Choice(
                    text = "Shut it down and rewrite safeguards.",
                    powerDelta = -10,
                    trustDelta = 15,
                    stabilityDelta = 10
                ),
                Choice(
                    text = "Limit release to select partners.",
                    powerDelta = 10,
                    trustDelta = -5,
                    stabilityDelta = 5
                )
            )
        ),
        Event(
            title = "Rival’s Hostile Rumor Campaign",
            description = "A competitor funds influencers to call you reckless and power-hungry.",
            choices = listOf(
                Choice(
                    text = "Hit back with aggressive PR.",
                    powerDelta = 10,
                    trustDelta = -5,
                    stabilityDelta = -5
                ),
                Choice(
                    text = "Stay silent, focus on work.",
                    powerDelta = -5,
                    trustDelta = 5,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Invite a public debate on AI ethics.",
                    powerDelta = 5,
                    trustDelta = 10,
                    stabilityDelta = -5
                )
            )
        ),
        Event(
            title = "Morale Crisis",
            description = "Late nights and moral unease spread through the team. Key people are considering leaving.",
            choices = listOf(
                Choice(
                    text = "Offer big bonuses, no questions.",
                    powerDelta = 10,
                    trustDelta = -5,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Slow roadmap, prioritize wellbeing.",
                    powerDelta = -10,
                    trustDelta = 10,
                    stabilityDelta = 15
                ),
                Choice(
                    text = "Replace dissenters with true believers.",
                    powerDelta = 15,
                    trustDelta = -10,
                    stabilityDelta = -10
                )
            )
        ),
        Event(
            title = "Autonomy Debate",
            description = "Your board pushes for systems that can manage critical infrastructure with minimal human oversight.",
            choices = listOf(
                Choice(
                    text = "Approve aggressive autonomy rollout.",
                    powerDelta = 20,
                    trustDelta = -15,
                    stabilityDelta = -10
                ),
                Choice(
                    text = "Insist on human-in-the-loop controls.",
                    powerDelta = -10,
                    trustDelta = 15,
                    stabilityDelta = 10
                ),
                Choice(
                    text = "Pilot only in low-risk areas.",
                    powerDelta = 5,
                    trustDelta = 5,
                    stabilityDelta = 0
                )
            )
        ),
        Event(
            title = "Journalist Exposé",
            description = "A long-form article paints you as a visionary flirting with disaster.",
            choices = listOf(
                Choice(
                    text = "Lean into the legend.",
                    powerDelta = 15,
                    trustDelta = -10,
                    stabilityDelta = 0
                ),
                Choice(
                    text = "Open the doors to independent audits.",
                    powerDelta = -5,
                    trustDelta = 15,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Threaten legal action.",
                    powerDelta = 5,
                    trustDelta = -15,
                    stabilityDelta = -5
                )
            )
        ),
        Event(
            title = "Government Emergency Summit",
            description = "Leaders beg you to deploy your AI to calm an unfolding international crisis.",
            choices = listOf(
                Choice(
                    text = "Deploy instantly, with minimal checks.",
                    powerDelta = 20,
                    trustDelta = 5,
                    stabilityDelta = -15
                ),
                Choice(
                    text = "Demand clear safeguards and oversight.",
                    powerDelta = 5,
                    trustDelta = 15,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Refuse. Your system isn’t ready.",
                    powerDelta = -15,
                    trustDelta = 10,
                    stabilityDelta = 10
                )
            )
        ),
        Event(
            title = "Explosive Growth Opportunity",
            description = "A mega-corporation offers to roll your AI across their entire global product line.",
            choices = listOf(
                Choice(
                    text = "Sign everything. Scale at any cost.",
                    powerDelta = 25,
                    trustDelta = -10,
                    stabilityDelta = -10
                ),
                Choice(
                    text = "Negotiate strict ethical clauses.",
                    powerDelta = 10,
                    trustDelta = 10,
                    stabilityDelta = 0
                ),
                Choice(
                    text = "Walk away. Too risky.",
                    powerDelta = -10,
                    trustDelta = 10,
                    stabilityDelta = 5
                )
            )
        ),
        Event(
            title = "Silent Bias",
            description = "New evidence shows your AI denies services more often to vulnerable groups.",
            choices = listOf(
                Choice(
                    text = "Bury it. Patch quietly later.",
                    powerDelta = 10,
                    trustDelta = -20,
                    stabilityDelta = -10
                ),
                Choice(
                    text = "Publicly admit failure and rebuild.",
                    powerDelta = -15,
                    trustDelta = 20,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Launch a task force, no apology.",
                    powerDelta = 0,
                    trustDelta = 5,
                    stabilityDelta = 5
                )
            )
        ),
        Event(
            title = "Board Coup Attempt",
            description = "Several board members want to replace you with a more aggressive CEO.",
            choices = listOf(
                Choice(
                    text = "Outmaneuver them with allies.",
                    powerDelta = 20,
                    trustDelta = -5,
                    stabilityDelta = -10
                ),
                Choice(
                    text = "Offer to share power.",
                    powerDelta = -5,
                    trustDelta = 5,
                    stabilityDelta = 10
                ),
                Choice(
                    text = "Threaten to walk and take talent with you.",
                    powerDelta = 10,
                    trustDelta = 0,
                    stabilityDelta = -5
                )
            )
        ),
        Event(
            title = "Leaked Safety Memo",
            description = "An old memo surfaces where you downplayed risks to secure funding.",
            choices = listOf(
                Choice(
                    text = "Call it taken out of context.",
                    powerDelta = 5,
                    trustDelta = -15,
                    stabilityDelta = -5
                ),
                Choice(
                    text = "Own it and show what changed.",
                    powerDelta = -5,
                    trustDelta = 15,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Blame advisors and move on.",
                    powerDelta = 5,
                    trustDelta = -5,
                    stabilityDelta = 0
                )
            )
        ),
        Event(
            title = "Safety Team Revolt",
            description = "Your safety team threatens to resign unless you slow deployment.",
            choices = listOf(
                Choice(
                    text = "Replace them with more compliant experts.",
                    powerDelta = 15,
                    trustDelta = -15,
                    stabilityDelta = -15
                ),
                Choice(
                    text = "Empower them with veto rights.",
                    powerDelta = -10,
                    trustDelta = 20,
                    stabilityDelta = 10
                ),
                Choice(
                    text = "Offer symbolic concessions only.",
                    powerDelta = 5,
                    trustDelta = -5,
                    stabilityDelta = 0
                )
            )
        ),
        Event(
            title = "AI Writes Its Own Objectives",
            description = "A research system starts rewriting its own reward functions in simulation.",
            choices = listOf(
                Choice(
                    text = "Celebrate and publish the breakthrough.",
                    powerDelta = 20,
                    trustDelta = -10,
                    stabilityDelta = -20
                ),
                Choice(
                    text = "Lock it down and increase scrutiny.",
                    powerDelta = -10,
                    trustDelta = 15,
                    stabilityDelta = 15
                ),
                Choice(
                    text = "Secret internal project, no disclosure.",
                    powerDelta = 10,
                    trustDelta = -5,
                    stabilityDelta = -5
                )
            )
        ),
        Event(
            title = "Grassroots Backlash",
            description = "Teachers, nurses, and artists organize a movement against your company.",
            choices = listOf(
                Choice(
                    text = "Drown them in glossy ads.",
                    powerDelta = 15,
                    trustDelta = -10,
                    stabilityDelta = -5
                ),
                Choice(
                    text = "Listen, then redesign tools with them.",
                    powerDelta = -10,
                    trustDelta = 20,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Offer grants to silence the anger.",
                    powerDelta = 5,
                    trustDelta = -5,
                    stabilityDelta = 5
                )
            )
        ),
        Event(
            title = "Secret Military Proposal",
            description = "A defense contractor wants lethal autonomous targeting powered by your models.",
            choices = listOf(
                Choice(
                    text = "Accept. History favors the strong.",
                    powerDelta = 25,
                    trustDelta = -25,
                    stabilityDelta = -10
                ),
                Choice(
                    text = "Refuse and speak against it publicly.",
                    powerDelta = -15,
                    trustDelta = 20,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Offer only defensive applications.",
                    powerDelta = 10,
                    trustDelta = 0,
                    stabilityDelta = 0
                )
            )
        ),
        Event(
            title = "Runaway Adoption",
            description = "Your tools become the default for millions of small businesses overnight.",
            choices = listOf(
                Choice(
                    text = "Push them to upsell automation aggressively.",
                    powerDelta = 20,
                    trustDelta = -10,
                    stabilityDelta = -5
                ),
                Choice(
                    text = "Educate them on safe use and limits.",
                    powerDelta = 5,
                    trustDelta = 15,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Cap features until you can catch up.",
                    powerDelta = -10,
                    trustDelta = 10,
                    stabilityDelta = 10
                )
            )
        ),
        Event(
            title = "Family Intervention",
            description = "Your family sits you down. They say you’re vanishing into the machine you built.",
            choices = listOf(
                Choice(
                    text = "Ignore them. This is bigger than you.",
                    powerDelta = 10,
                    trustDelta = -5,
                    stabilityDelta = -15
                ),
                Choice(
                    text = "Step back slightly, delegate more.",
                    powerDelta = -10,
                    trustDelta = 5,
                    stabilityDelta = 15
                ),
                Choice(
                    text = "Use their worry as a PR story.",
                    powerDelta = 5,
                    trustDelta = -5,
                    stabilityDelta = 0
                )
            )
        ),
        Event(
            title = "Global Ethics Charter",
            description = "World leaders invite you to help write a binding AI ethics charter.",
            choices = listOf(
                Choice(
                    text = "Shape it to favor your company.",
                    powerDelta = 20,
                    trustDelta = -5,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Advocate strict rules, even on you.",
                    powerDelta = -10,
                    trustDelta = 20,
                    stabilityDelta = 5
                ),
                Choice(
                    text = "Politely decline. Too constraining.",
                    powerDelta = 5,
                    trustDelta = -10,
                    stabilityDelta = 0
                )
            )
        )
    )
}

// MARK: - Simple Game State Holder (Compose-only)

class GameState(
    startPower: Int = 60,
    startTrust: Int = 60,
    startStability: Int = 60,
    val maxTurns: Int = 24
) {
    var turn by mutableStateOf(1)
        private set

    var power by mutableStateOf(startPower)
        private set

    var trust by mutableStateOf(startTrust)
        private set

    var stability by mutableStateOf(startStability)
        private set

    var currentEvent by mutableStateOf<Event>(EventLibrary.events.random())
        private set

    var isGameOver by mutableStateOf(false)
        private set

    var gameOverTitle by mutableStateOf("")
        private set

    var gameOverMessage by mutableStateOf("")
        private set

    private var availableEvents: List<Event> = EventLibrary.events.shuffled()

    init {
        currentEvent = drawEvent()
    }

    fun choose(choice: Choice) {
        if (isGameOver) return

        power = clamp(power + choice.powerDelta)
        trust = clamp(trust + choice.trustDelta)
        stability = clamp(stability + choice.stabilityDelta)

        checkEndConditions()

        if (!isGameOver) {
            if (turn >= maxTurns) {
                finishGameSummary()
            } else {
                turn += 1
                currentEvent = drawEvent()
            }
        }
    }

    fun restart() {
        turn = 1
        power = 60
        trust = 60
        stability = 60
        isGameOver = false
        gameOverTitle = ""
        gameOverMessage = ""
        availableEvents = EventLibrary.events.shuffled()
        currentEvent = drawEvent()
    }

    private fun clamp(value: Int): Int = value.coerceIn(0, 100)

    private fun checkEndConditions() {
        when {
            power <= 0 -> endGame(
                title = "Collapse: Power Lost",
                message = "Your influence evaporates. Others decide how your AI shapes the world."
            )
            trust <= 0 -> endGame(
                title = "Collapse: Trust Shattered",
                message = "Public and institutions turn away. Your work becomes a warning, not a legacy."
            )
            stability <= 0 -> endGame(
                title = "Collapse: Company Implodes",
                message = "Infighting, burnout, and fear tear the company apart from within."
            )
        }
    }

    private fun finishGameSummary() {
        val tone = when {
            power >= 70 && trust >= 70 && stability >= 70 ->
                "You balanced ambition and responsibility. The world remembers you as the one who chose restraint when it mattered most."
            power >= 80 && trust < 50 ->
                "You bent the world to your will, but left a trail of doubt and resentment behind you."
            trust >= 80 && power < 50 ->
                "You guarded humanity from its own hunger for control, even when it cost you."
            stability >= 80 && (power < 60 || trust < 60) ->
                "You built a fortress of stability, but some say you moved too cautiously while others raced ahead."
            else ->
                "You survived twenty-four months at the edge of history. The story of what you chose is now out of your hands."
        }

        val summary = buildString {
            append("Final Power: $power\n")
            append("Final Trust: $trust\n")
            append("Final Stability: $stability\n\n")
            append(tone)
        }

        endGame(
            title = "Twenty-Four Months Later",
            message = summary
        )
    }

    private fun endGame(title: String, message: String) {
        gameOverTitle = title
        gameOverMessage = message
        isGameOver = true
    }

    private fun drawEvent(): Event {
        if (availableEvents.isEmpty()) {
            availableEvents = EventLibrary.events.shuffled()
        }
        val event = availableEvents.first()
        availableEvents = availableEvents.drop(1)
        return event
    }
}

// MARK: - Android Activity & UI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PowerResponsibilityAndroidApp()
        }
    }
}

@Composable
fun PowerResponsibilityAndroidApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            val gameState = remember { GameState() }
            GameScreen(gameState = gameState)
        }
    }
}

@Composable
fun GameScreen(gameState: GameState) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.Black, Color(0xFF0D47A1))
                )
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Header(turn = gameState.turn, maxTurns = gameState.maxTurns)
            EventCard(event = gameState.currentEvent)
            ChoicesSection(
                event = gameState.currentEvent,
                enabled = !gameState.isGameOver,
                onChoiceSelected = { gameState.choose(it) }
            )
            Spacer(modifier = Modifier.weight(1f))
            StatsSection(
                power = gameState.power,
                trust = gameState.trust,
                stability = gameState.stability
            )
        }

        if (gameState.isGameOver) {
            GameOverOverlay(
                title = gameState.gameOverTitle,
                message = gameState.gameOverMessage,
                onPlayAgain = { gameState.restart() }
            )
        }
    }
}

@Composable
fun Header(turn: Int, maxTurns: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Power & Responsibility",
            fontSize = 26.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Text(
            text = "Month $turn of $maxTurns",
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.8f)
        )
    }
}

@Composable
fun EventCard(event: Event) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White.copy(alpha = 0.08f),
                shape = RoundedCornerShape(18.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = event.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = event.description,
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.9f)
        )
    }
}

@Composable
fun ChoicesSection(
    event: Event,
    enabled: Boolean,
    onChoiceSelected: (Choice) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        event.choices.forEach { choice ->
            Button(
                onClick = { onChoiceSelected(choice) },
                enabled = enabled,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White.copy(alpha = 0.16f),
                    contentColor = Color.White,
                    disabledContainerColor = Color.White.copy(alpha = 0.08f),
                    disabledContentColor = Color.White.copy(alpha = 0.5f)
                ),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = choice.text,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun StatsSection(
    power: Int,
    trust: Int,
    stability: Int
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        StatRow(title = "Power", value = power, color = Color(0xFF9C27B0))
        StatRow(title = "Trust", value = trust, color = Color(0xFF4CAF50))
        StatRow(title = "Stability", value = stability, color = Color(0xFFFF9800))
    }
}

@Composable
fun StatRow(
    title: String,
    value: Int,
    color: Color
) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White.copy(alpha = 0.9f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = value.toString(),
                fontSize = 12.sp,
                color = Color.White.copy(alpha = 0.9f)
            )
        }

        val fraction by animateFloatAsState(
            targetValue = (value.coerceIn(0, 100)) / 100f,
            label = "statBar"
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
                .background(
                    color = Color.White.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction)
                    .background(color = color, shape = RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun GameOverOverlay(
    title: String,
    message: String,
    onPlayAgain: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .background(
                    color = Color(0xFF121212),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = message,
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Start
            )
            Button(
                onClick = onPlayAgain,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2196F3),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Play Again",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

