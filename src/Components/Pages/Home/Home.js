
import "../Home/Home.css";
import Tabs1 from "../../Tabs/Tabs.js";
import User_login from "../User/User_login.js";


const Home = () =>{
 
    return(
        <div id="home">   
            
          <div id="home-top">
          <div id="home-left">
          <p> Discover a world of opportunities where innovation thrives. Join us in shaping the future and be part of a dynamic, diverse team.</p>
            </div>  
            <div id="home-right">
            <Tabs1 />
            </div>
            
          </div>
          <User_login />
        </div>
    )

}

export default Home;




