function ListofPlayers() {

    const players = [
        { name: "Virat", score: 95 },
        { name: "Rohit", score: 82 },
        { name: "Gill", score: 65 },
        { name: "Rahul", score: 45 },
        { name: "Surya", score: 78 },
        { name: "Hardik", score: 69 },
        { name: "Jadeja", score: 72 },
        { name: "Ashwin", score: 55 },
        { name: "Bumrah", score: 88 },
        { name: "Shami", score: 61 },
        { name: "Siraj", score: 80 }
    ];

    const lowScorePlayers = players.filter(player => player.score < 70);

    return (
        <div>

            <h2>List of Players</h2>

            {players.map((player, index) => (
                <p key={index}>
                    {player.name} - {player.score}
                </p>
            ))}

            <h2>Players with Score Below 70</h2>

            {lowScorePlayers.map((player, index) => (
                <p key={index}>
                    {player.name} - {player.score}
                </p>
            ))}

        </div>
    );

}

export default ListofPlayers;