import './App.css';
import { Route,Routes,BrowserRouter } from 'react-router-dom';
import Home from './Components/Pages/Home/Home';
import User from './Components/Pages/User/User';
import Nav_bar from './Components/Common/Navbar/Navbar';
import Footer from './Components/Common/Footer/Footer';
import Admin_login from './Components/Pages/Admin/Admin';
import User_login from './Components/Pages/User/User_login';
import Employee_login from './Components/Pages/Employe/Employe';
import Admin_function from './Components/Pages/Admin/Admin_function';
import Employ_register from './Components/Pages/Employe/Employe_registration';
import User_dashboard from './Components/Pages/User/User_dashboard';
import Employe_Dashboard from './Components/Pages/Employe/Employe_dashboard.js';
function App() {
  return (
      
    <BrowserRouter>
    
         <Nav_bar />
         <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/user" element={<User />} />
          <Route path='admin/login' element={<Admin_login />} />
          <Route path='/user/login' element={<User_login />} />
          <Route path='/employe/login' element={<Employee_login />} />
          <Route path='/admin/functions' element = {<Admin_function />} />
          <Route path='/employe-register' element = {<Employ_register />} />
          <Route path='/user/dashboard/:userId' element= {<User_dashboard /> } />
          <Route path='/employe/dashboard' element = {<Employe_Dashboard />} />
        </Routes>
         <Footer />
      
   
    
    
    </BrowserRouter>

    
  );
}

export default App;
