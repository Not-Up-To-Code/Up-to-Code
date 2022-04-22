const app=Vue.createApp({
    //data,functions
    //template: '<h2> i am the template </h2>'

data(){
    return{
        showBooks: true,
        url: "www.google.com",
        //title: 'final empire',
        //author: 'king sina khajehpour',
        //age: 45,

        books:[
            {title: 'final empire',author: 'king sina khajehpour',age: 45,img:"source"},
            {title: 'history of my kingdom',author: 'king sina khajehpour',age: 45,img:"source"},
            {title: 'get the whole world',author: 'king sina khajehpour',age: 45,img:"source"},
        ],
        x:0,
        y:0,
    }
},
methods:{
    toggleShowBooks(){
        this.showBooks=!this.showBooks

    },
    handleEvent(e,data){
       console.log(e,e.type)
       if(data){
           console.log(data)
       }

    },
    handleMousemove(e){
        this.x=e.offsetX
        this.y=e.offsetY


    },
    
    changeTitle(title){
        //this.title="change me quickly"
        this.title= title
    }
}

})

app.mount('#app')