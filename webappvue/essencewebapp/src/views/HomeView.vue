<template>
    <p>Message is: {{ message }}</p>
<div class="outer">
    <div class="top">Alpha card name </div>
    <input v-model="message" class="alpha" placeholder="Alpha name"/>
    <input v-model="message" class="moove" placeholder="state1"/>
    <input v-model="message" class="moove" placeholder="state2"/>
    <input v-model="message" class="moove" placeholder="state3"/>
    <input v-model="message" class="moove" placeholder="state4"/>
    <input v-model="message" class="moove" placeholder="state5"/>
    <input v-model="message" class="moove" placeholder="state6"/>
    <input v-model="message" class="brief" placeholder="brief description"/>
    <input v-model="message" class="detaildescription" placeholder="detail deescription"/>


   </div>
</template>

<style>
.alpha{
    display: list-item;
    background: rgb(225, 225, 68);
    border-color: rgb(225, 225, 68);
    position: relative;
    border-radius: 10px;
    width: 30%;
    padding: 10px 20px;
    top:-60px;
    left:10%;

     

}
.moove{
    display: list-item;
    background: white;
    position: relative;
    border-color: red;
    border-radius: 10px;
    width: 30%;
    padding: 10px 20px;
    top:0px;
    left:2%;
    margin: 20px;
    bottom: 20px; 
}

.brief{
    display: list-item;
    background: white;
    position: relative;
    border-color: red;
    border-radius: 10px;
    width: 30%;
    padding: 50px 20px;
    top:-355px;
    left:50%;
    margin: 20px;
   
}
.detaildescription{
    display: list-item;
    background: white;
    position: relative;
    border-color: red;
    border-radius: 10px;
    width: 30%;
    padding: 50px 20px;
    top:-300px;
    left:50%;
    margin: 20px;
    bottom: 70px;
}
div.outer{
    -webkit-border-radius: 20px;
    -moz-border-radius: 20px;
    border-radius: 20px;
    overflow: hidden;
    border-color: red;
    background-color: gray;
    margin: 0px 200px ;
    padding: 0px 0px;
    height: 550px;
}

div.outer .top{
    border-radius: 10px;
    padding: 30px 240px;
    width: 50%;
    background-color: rgb(225, 225, 68);
}

</style>