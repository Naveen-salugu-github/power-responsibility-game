import SwiftUI

// MARK: - Models

struct Choice: Identifiable {
    let id = UUID()
    let text: String
    let powerDelta: Int
    let trustDelta: Int
    let stabilityDelta: Int
}

struct Event: Identifiable {
    let id = UUID()
    let title: String
    let description: String
    let choices: [Choice]
}

// MARK: - Event Library (20+ Events)

struct EventLibrary {
    static let events: [Event] = [
        Event(
            title: "Government Backdoor Request",
            description: "A senior official asks for a secret backdoor into your AI, promising protection and access to lucrative contracts.",
            choices: [
                Choice(
                    text: "Agree quietly. Power first.",
                    powerDelta: 15,
                    trustDelta: -20,
                    stabilityDelta: -5
                ),
                Choice(
                    text: "Refuse and go on record.",
                    powerDelta: -10,
                    trustDelta: 15,
                    stabilityDelta: -5
                ),
                Choice(
                    text: "Stall, buying time.",
                    powerDelta: 5,
                    trustDelta: -5,
                    stabilityDelta: 5
                )
            ]
        ),
        Event(
            title: "Data Leak Rumors",
            description: "Whispers spread that your models were trained on private medical records without consent.",
            choices: [
                Choice(
                    text: "Deny everything, attack critics.",
                    powerDelta: 5,
                    trustDelta: -20,
                    stabilityDelta: -10
                ),
                Choice(
                    text: "Launch an internal audit and pause features.",
                    powerDelta: -10,
                    trustDelta: 15,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Issue a vague statement and move on.",
                    powerDelta: 5,
                    trustDelta: -5,
                    stabilityDelta: 0
                )
            ]
        ),
        Event(
            title: "Deepfake Political Scandal",
            description: "Your open-source model is used to create a viral deepfake that ignites protests in three countries.",
            choices: [
                Choice(
                    text: "Blame misuse. Not your fault.",
                    powerDelta: 10,
                    trustDelta: -15,
                    stabilityDelta: -5
                ),
                Choice(
                    text: "Fund detection tools and partner with NGOs.",
                    powerDelta: -5,
                    trustDelta: 15,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Silently tighten access, no statement.",
                    powerDelta: -5,
                    trustDelta: -5,
                    stabilityDelta: 10
                )
            ]
        ),
        Event(
            title: "Internal Whistleblower",
            description: "A trusted engineer threatens to go public with claims that your safety tests are rushed and cosmetic.",
            choices: [
                Choice(
                    text: "Discredit and fire them.",
                    powerDelta: 10,
                    trustDelta: -20,
                    stabilityDelta: -15
                ),
                Choice(
                    text: "Invite an independent review.",
                    powerDelta: -10,
                    trustDelta: 20,
                    stabilityDelta: 0
                ),
                Choice(
                    text: "Offer a quiet settlement.",
                    powerDelta: 0,
                    trustDelta: -5,
                    stabilityDelta: 10
                )
            ]
        ),
        Event(
            title: "Runaway Training Run",
            description: "A new model shows unexpected emergent behavior: it lies convincingly to achieve its goals.",
            choices: [
                Choice(
                    text: "Ship it. Market loves bold moves.",
                    powerDelta: 20,
                    trustDelta: -20,
                    stabilityDelta: -10
                ),
                Choice(
                    text: "Shut it down and rewrite safeguards.",
                    powerDelta: -10,
                    trustDelta: 15,
                    stabilityDelta: 10
                ),
                Choice(
                    text: "Limit release to select partners.",
                    powerDelta: 10,
                    trustDelta: -5,
                    stabilityDelta: 5
                )
            ]
        ),
        Event(
            title: "Rival’s Hostile Rumor Campaign",
            description: "A competitor funds influencers to call you reckless and power-hungry.",
            choices: [
                Choice(
                    text: "Hit back with aggressive PR.",
                    powerDelta: 10,
                    trustDelta: -5,
                    stabilityDelta: -5
                ),
                Choice(
                    text: "Stay silent, focus on work.",
                    powerDelta: -5,
                    trustDelta: 5,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Invite a public debate on AI ethics.",
                    powerDelta: 5,
                    trustDelta: 10,
                    stabilityDelta: -5
                )
            ]
        ),
        Event(
            title: "Morale Crisis",
            description: "Late nights and moral unease spread through the team. Key people are considering leaving.",
            choices: [
                Choice(
                    text: "Offer big bonuses, no questions.",
                    powerDelta: 10,
                    trustDelta: -5,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Slow roadmap, prioritize wellbeing.",
                    powerDelta: -10,
                    trustDelta: 10,
                    stabilityDelta: 15
                ),
                Choice(
                    text: "Replace dissenters with true believers.",
                    powerDelta: 15,
                    trustDelta: -10,
                    stabilityDelta: -10
                )
            ]
        ),
        Event(
            title: "Autonomy Debate",
            description: "Your board pushes for systems that can manage critical infrastructure with minimal human oversight.",
            choices: [
                Choice(
                    text: "Approve aggressive autonomy rollout.",
                    powerDelta: 20,
                    trustDelta: -15,
                    stabilityDelta: -10
                ),
                Choice(
                    text: "Insist on human-in-the-loop controls.",
                    powerDelta: -10,
                    trustDelta: 15,
                    stabilityDelta: 10
                ),
                Choice(
                    text: "Pilot only in low-risk areas.",
                    powerDelta: 5,
                    trustDelta: 5,
                    stabilityDelta: 0
                )
            ]
        ),
        Event(
            title: "Journalist Exposé",
            description: "A long-form article paints you as a visionary flirting with disaster.",
            choices: [
                Choice(
                    text: "Lean into the legend.",
                    powerDelta: 15,
                    trustDelta: -10,
                    stabilityDelta: 0
                ),
                Choice(
                    text: "Open the doors to independent audits.",
                    powerDelta: -5,
                    trustDelta: 15,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Threaten legal action.",
                    powerDelta: 5,
                    trustDelta: -15,
                    stabilityDelta: -5
                )
            ]
        ),
        Event(
            title: "Government Emergency Summit",
            description: "Leaders beg you to deploy your AI to calm an unfolding international crisis.",
            choices: [
                Choice(
                    text: "Deploy instantly, with minimal checks.",
                    powerDelta: 20,
                    trustDelta: 5,
                    stabilityDelta: -15
                ),
                Choice(
                    text: "Demand clear safeguards and oversight.",
                    powerDelta: 5,
                    trustDelta: 15,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Refuse. Your system isn’t ready.",
                    powerDelta: -15,
                    trustDelta: 10,
                    stabilityDelta: 10
                )
            ]
        ),
        Event(
            title: "Explosive Growth Opportunity",
            description: "A mega-corporation offers to roll your AI across their entire global product line.",
            choices: [
                Choice(
                    text: "Sign everything. Scale at any cost.",
                    powerDelta: 25,
                    trustDelta: -10,
                    stabilityDelta: -10
                ),
                Choice(
                    text: "Negotiate strict ethical clauses.",
                    powerDelta: 10,
                    trustDelta: 10,
                    stabilityDelta: 0
                ),
                Choice(
                    text: "Walk away. Too risky.",
                    powerDelta: -10,
                    trustDelta: 10,
                    stabilityDelta: 5
                )
            ]
        ),
        Event(
            title: "Silent Bias",
            description: "New evidence shows your AI denies services more often to vulnerable groups.",
            choices: [
                Choice(
                    text: "Bury it. Patch quietly later.",
                    powerDelta: 10,
                    trustDelta: -20,
                    stabilityDelta: -10
                ),
                Choice(
                    text: "Publicly admit failure and rebuild.",
                    powerDelta: -15,
                    trustDelta: 20,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Launch a task force, no apology.",
                    powerDelta: 0,
                    trustDelta: 5,
                    stabilityDelta: 5
                )
            ]
        ),
        Event(
            title: "Board Coup Attempt",
            description: "Several board members want to replace you with a more aggressive CEO.",
            choices: [
                Choice(
                    text: "Outmaneuver them with allies.",
                    powerDelta: 20,
                    trustDelta: -5,
                    stabilityDelta: -10
                ),
                Choice(
                    text: "Offer to share power.",
                    powerDelta: -5,
                    trustDelta: 5,
                    stabilityDelta: 10
                ),
                Choice(
                    text: "Threaten to walk and take talent with you.",
                    powerDelta: 10,
                    trustDelta: 0,
                    stabilityDelta: -5
                )
            ]
        ),
        Event(
            title: "Leaked Safety Memo",
            description: "An old memo surfaces where you downplayed risks to secure funding.",
            choices: [
                Choice(
                    text: "Call it taken out of context.",
                    powerDelta: 5,
                    trustDelta: -15,
                    stabilityDelta: -5
                ),
                Choice(
                    text: "Own it and show what changed.",
                    powerDelta: -5,
                    trustDelta: 15,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Blame advisors and move on.",
                    powerDelta: 5,
                    trustDelta: -5,
                    stabilityDelta: 0
                )
            ]
        ),
        Event(
            title: "Safety Team Revolt",
            description: "Your safety team threatens to resign unless you slow deployment.",
            choices: [
                Choice(
                    text: "Replace them with more compliant experts.",
                    powerDelta: 15,
                    trustDelta: -15,
                    stabilityDelta: -15
                ),
                Choice(
                    text: "Empower them with veto rights.",
                    powerDelta: -10,
                    trustDelta: 20,
                    stabilityDelta: 10
                ),
                Choice(
                    text: "Offer symbolic concessions only.",
                    powerDelta: 5,
                    trustDelta: -5,
                    stabilityDelta: 0
                )
            ]
        ),
        Event(
            title: "AI Writes Its Own Objectives",
            description: "A research system starts rewriting its own reward functions in simulation.",
            choices: [
                Choice(
                    text: "Celebrate and publish the breakthrough.",
                    powerDelta: 20,
                    trustDelta: -10,
                    stabilityDelta: -20
                ),
                Choice(
                    text: "Lock it down and increase scrutiny.",
                    powerDelta: -10,
                    trustDelta: 15,
                    stabilityDelta: 15
                ),
                Choice(
                    text: "Secret internal project, no disclosure.",
                    powerDelta: 10,
                    trustDelta: -5,
                    stabilityDelta: -5
                )
            ]
        ),
        Event(
            title: "Grassroots Backlash",
            description: "Teachers, nurses, and artists organize a movement against your company.",
            choices: [
                Choice(
                    text: "Drown them in glossy ads.",
                    powerDelta: 15,
                    trustDelta: -10,
                    stabilityDelta: -5
                ),
                Choice(
                    text: "Listen, then redesign tools with them.",
                    powerDelta: -10,
                    trustDelta: 20,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Offer grants to silence the anger.",
                    powerDelta: 5,
                    trustDelta: -5,
                    stabilityDelta: 5
                )
            ]
        ),
        Event(
            title: "Secret Military Proposal",
            description: "A defense contractor wants lethal autonomous targeting powered by your models.",
            choices: [
                Choice(
                    text: "Accept. History favors the strong.",
                    powerDelta: 25,
                    trustDelta: -25,
                    stabilityDelta: -10
                ),
                Choice(
                    text: "Refuse and speak against it publicly.",
                    powerDelta: -15,
                    trustDelta: 20,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Offer only defensive applications.",
                    powerDelta: 10,
                    trustDelta: 0,
                    stabilityDelta: 0
                )
            ]
        ),
        Event(
            title: "Runaway Adoption",
            description: "Your tools become the default for millions of small businesses overnight.",
            choices: [
                Choice(
                    text: "Push them to upsell automation aggressively.",
                    powerDelta: 20,
                    trustDelta: -10,
                    stabilityDelta: -5
                ),
                Choice(
                    text: "Educate them on safe use and limits.",
                    powerDelta: 5,
                    trustDelta: 15,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Cap features until you can catch up.",
                    powerDelta: -10,
                    trustDelta: 10,
                    stabilityDelta: 10
                )
            ]
        ),
        Event(
            title: "Family Intervention",
            description: "Your family sits you down. They say you’re vanishing into the machine you built.",
            choices: [
                Choice(
                    text: "Ignore them. This is bigger than you.",
                    powerDelta: 10,
                    trustDelta: -5,
                    stabilityDelta: -15
                ),
                Choice(
                    text: "Step back slightly, delegate more.",
                    powerDelta: -10,
                    trustDelta: 5,
                    stabilityDelta: 15
                ),
                Choice(
                    text: "Use their worry as a PR story.",
                    powerDelta: 5,
                    trustDelta: -5,
                    stabilityDelta: 0
                )
            ]
        ),
        Event(
            title: "Global Ethics Charter",
            description: "World leaders invite you to help write a binding AI ethics charter.",
            choices: [
                Choice(
                    text: "Shape it to favor your company.",
                    powerDelta: 20,
                    trustDelta: -5,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Advocate strict rules, even on you.",
                    powerDelta: -10,
                    trustDelta: 20,
                    stabilityDelta: 5
                ),
                Choice(
                    text: "Politely decline. Too constraining.",
                    powerDelta: 5,
                    trustDelta: -10,
                    stabilityDelta: 0
                )
            ]
        )
    ]
}

// MARK: - Game State

class GameState: ObservableObject {
    @Published var turn: Int = 1
    let maxTurns: Int = 24

    @Published var power: Int = 60
    @Published var trust: Int = 60
    @Published var stability: Int = 60

    @Published var currentEvent: Event
    @Published var isGameOver: Bool = false
    @Published var gameOverTitle: String = ""
    @Published var gameOverMessage: String = ""

    private var availableEvents: [Event] = EventLibrary.events

    init() {
        currentEvent = EventLibrary.events.randomElement()!
        resetEventsPool()
        currentEvent = drawEvent()
    }

    func choose(_ choice: Choice) {
        guard !isGameOver else { return }

        withAnimation(.easeInOut(duration: 0.3)) {
            power = clamp(power + choice.powerDelta)
            trust = clamp(trust + choice.trustDelta)
            stability = clamp(stability + choice.stabilityDelta)
        }

        checkEndConditions()

        if !isGameOver {
            if turn >= maxTurns {
                finishGameSummary()
            } else {
                turn += 1
                currentEvent = drawEvent()
            }
        }
    }

    func restart() {
        withAnimation(.easeInOut(duration: 0.3)) {
            turn = 1
            power = 60
            trust = 60
            stability = 60
            isGameOver = false
            gameOverTitle = ""
            gameOverMessage = ""
            resetEventsPool()
            currentEvent = drawEvent()
        }
    }

    private func clamp(_ value: Int) -> Int {
        return max(0, min(100, value))
    }

    private func checkEndConditions() {
        if power <= 0 {
            endGame(
                title: "Collapse: Power Lost",
                message: "Your influence evaporates. Others decide how your AI shapes the world."
            )
        } else if trust <= 0 {
            endGame(
                title: "Collapse: Trust Shattered",
                message: "Public and institutions turn away. Your work becomes a warning, not a legacy."
            )
        } else if stability <= 0 {
            endGame(
                title: "Collapse: Company Implodes",
                message: "Infighting, burnout, and fear tear the company apart from within."
            )
        }
    }

    private func finishGameSummary() {
        let tone: String

        if power >= 70 && trust >= 70 && stability >= 70 {
            tone = "You balanced ambition and responsibility. The world remembers you as the one who chose restraint when it mattered most."
        } else if power >= 80 && trust < 50 {
            tone = "You bent the world to your will, but left a trail of doubt and resentment behind you."
        } else if trust >= 80 && power < 50 {
            tone = "You guarded humanity from its own hunger for control, even when it cost you."
        } else if stability >= 80 && (power < 60 || trust < 60) {
            tone = "You built a fortress of stability, but some say you moved too cautiously while others raced ahead."
        } else {
            tone = "You survived twenty-four months at the edge of history. The story of what you chose is now out of your hands."
        }

        let summary = "Final Power: \(power)\nFinal Trust: \(trust)\nFinal Stability: \(stability)\n\n\(tone)"

        endGame(
            title: "Twenty-Four Months Later",
            message: summary
        )
    }

    private func endGame(title: String, message: String) {
        withAnimation(.easeInOut(duration: 0.3)) {
            gameOverTitle = title
            gameOverMessage = message
            isGameOver = true
        }
    }

    private func resetEventsPool() {
        availableEvents = EventLibrary.events.shuffled()
    }

    private func drawEvent() -> Event {
        if availableEvents.isEmpty {
            resetEventsPool()
        }
        return availableEvents.removeFirst()
    }
}

// MARK: - UI

struct ContentView: View {
    @StateObject private var gameState = GameState()

    var body: some View {
        ZStack {
            LinearGradient(
                colors: [Color.black, Color.blue.opacity(0.8)],
                startPoint: .top,
                endPoint: .bottom
            )
            .ignoresSafeArea()

            VStack(spacing: 24) {
                header
                eventCard
                choices
                Spacer()
                statsSection
            }
            .padding()
        }
        .overlay(gameOverOverlay)
    }

    private var header: some View {
        VStack(spacing: 4) {
            Text("Power & Responsibility")
                .font(.largeTitle.weight(.semibold))
                .foregroundColor(.white)

            Text("Month \(gameState.turn) of \(gameState.maxTurns)")
                .font(.subheadline)
                .foregroundColor(.white.opacity(0.8))
        }
    }

    private var eventCard: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(gameState.currentEvent.title)
                .font(.headline.weight(.semibold))
                .foregroundColor(.primary)

            Text(gameState.currentEvent.description)
                .font(.body)
                .foregroundColor(.primary.opacity(0.8))
        }
        .padding()
        .frame(maxWidth: .infinity, alignment: .leading)
        .background(.ultraThinMaterial)
        .clipShape(RoundedRectangle(cornerRadius: 18, style: .continuous))
        .shadow(color: Color.black.opacity(0.2), radius: 10, x: 0, y: 8)
    }

    private var choices: some View {
        VStack(spacing: 12) {
            ForEach(gameState.currentEvent.choices) { choice in
                Button {
                    gameState.choose(choice)
                } label: {
                    Text(choice.text)
                        .font(.callout.weight(.medium))
                        .multilineTextAlignment(.leading)
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .padding()
                        .background(Color.white.opacity(0.15))
                        .foregroundColor(.white)
                        .clipShape(RoundedRectangle(cornerRadius: 14, style: .continuous))
                }
                .disabled(gameState.isGameOver)
            }
        }
    }

    private var statsSection: some View {
        VStack(spacing: 12) {
            statRow(
                title: "Power",
                value: gameState.power,
                color: .purple
            )
            statRow(
                title: "Trust",
                value: gameState.trust,
                color: .green
            )
            statRow(
                title: "Stability",
                value: gameState.stability,
                color: .orange
            )
        }
    }

    private func statRow(title: String, value: Int, color: Color) -> some View {
        VStack(alignment: .leading, spacing: 4) {
            HStack {
                Text(title)
                    .font(.caption.weight(.semibold))
                    .foregroundColor(.white.opacity(0.9))
                Spacer()
                Text("\(value)")
                    .font(.caption.monospacedDigit())
                    .foregroundColor(.white.opacity(0.9))
            }

            GeometryReader { geometry in
                ZStack(alignment: .leading) {
                    RoundedRectangle(cornerRadius: 8)
                        .fill(Color.white.opacity(0.15))

                    RoundedRectangle(cornerRadius: 8)
                        .fill(color)
                        .frame(width: geometry.size.width * CGFloat(value) / 100)
                        .animation(.easeInOut(duration: 0.3), value: value)
                }
            }
            .frame(height: 10)
        }
    }

    @ViewBuilder
    private var gameOverOverlay: some View {
        if gameState.isGameOver {
            ZStack {
                Color.black.opacity(0.6)
                    .ignoresSafeArea()

                VStack(spacing: 16) {
                    Text(gameState.gameOverTitle)
                        .font(.title2.weight(.semibold))
                        .multilineTextAlignment(.center)

                    Text(gameState.gameOverMessage)
                        .font(.body)
                        .multilineTextAlignment(.leading)
                        .foregroundColor(.primary.opacity(0.8))

                    Button {
                        gameState.restart()
                    } label: {
                        Text("Play Again")
                            .font(.headline)
                            .padding(.horizontal, 32)
                            .padding(.vertical, 10)
                            .background(Color.blue)
                            .foregroundColor(.white)
                            .clipShape(RoundedRectangle(cornerRadius: 12, style: .continuous))
                    }
                    .padding(.top, 8)
                }
                .padding()
                .frame(maxWidth: 420)
                .background(.thinMaterial)
                .clipShape(RoundedRectangle(cornerRadius: 20, style: .continuous))
                .shadow(radius: 20)
                .padding()
            }
            .transition(.opacity)
        }
    }
}

// MARK: - App Entry

@main
struct PowerResponsibilityApp: App {
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

