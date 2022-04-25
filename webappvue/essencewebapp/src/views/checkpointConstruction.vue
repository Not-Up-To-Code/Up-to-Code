<template>>
<head>
    <meta charset="UTF-8">
    <title>Essence Kernel Tools</title>
    <link rel="stylesheet" href="style.css">
</head>
<body id="body">
    <div class="grid-container">
        <div id="header" class="header">
            <h1>
                Essence Kernel Tools
            </h1>
        </div>

        <div id="menu" class="menu">
            <router-link to="/">Home</router-link> |
            <router-link to="/about">About</router-link>
            <router-link to="/practiceCreator">Create Essence Practice</router-link>
            <router-link to="/cardCatalog">Essence Card Catalog</router-link>
            <router-link to="/cardCreator">Create Essence Cards</router-link>
            <p id="menuLabel">Essence games</p>
            <router-link to="/progressPoker">Progress Poker</router-link>
            <router-link to="/chaseTheState">Chase The State</router-link>
            <router-link to="/objectiveGo">Objective Go</router-link>
            <router-link to="/checkpointConstruction">Checkpoint Construction</router-link>
            <router-link to="/practiceCatalog">Practice Catalog</router-link>
        </div>
        <div id="content" class="content">

        </div>
    </div>
</body>
</template>
<style>
html{
    margin: 0px;
    padding: 0px;
}

#body{
    margin: 0px;
    padding: 0px;
    background-color: #000E0F;
}

.grid-container{
    display: grid;
    grid-template-columns: 20% 80%;
    grid-template-areas:
    "header content"
    "menu content"
    ;
}

#header{
    grid-area: header;
    background-color: #1B5559;
    color: white;
    text-align: center;
    font-size: 20px;
}

#menu{
    grid-area: menu;
    background-color: #1B5559;
}

#menu a{
    background-color: #1B5559;
    color: white;
    display: block;
    padding: 12px;
    text-decoration: none;
}

#menu a:hover{
    background-color: #2c7379;
}

#menu a.active{
    background-color: #449ca1;
}

#menuLabel{
    background-color: #000E0F;
    color: white;
    padding: 12px;
}


</style>