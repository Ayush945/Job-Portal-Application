import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Homepage from './pages/Homepage'
import FindSalaries from './pages/FindSalaries'
import FindCompanies from './pages/FindCompanies'
import Navigation from './Components/Navigation'
import Profile from './pages/Profile'
import Notification from './pages/Notification'
import Message from './pages/Message'
import PostJob from './pages/PostJob'
import Login from './pages/Login_and_Register_Pages/Login'
import RegisterCompany from './pages/Login_and_Register_Pages/RegisterCompany'
import RegisterJobSeeker from './pages/Login_and_Register_Pages/RegisterJobSeeker'
import LoginCompany from './pages/Login_and_Register_Pages/LoginCompany'
import AdminSideBar from './Components/AdminSideBar'


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='admin-dashboard' element={<AdminSideBar />}></Route>
        <Route path='' element={<Navigation />} >
          <Route path='/' element={<Homepage />} />
          <Route path='/find-salaries' element={<FindSalaries />} />
          <Route path='/find-companies' element={<FindCompanies />} />
          <Route path='/profile' element={<Profile />} />
          <Route path='/notification' element={<Notification />} />
          <Route path='/message' element={<Message />} />
          <Route path='post-job' element={<PostJob />} />
          <Route path='/login' element={<Login />} />
          <Route path='/register-company' element={<RegisterCompany />} />
          <Route path='/register-jobseeker' element={<RegisterJobSeeker />} />
          <Route path='login-company' element={<LoginCompany />} />
        </Route>
      </Routes>



    </BrowserRouter>
  )
}

export default App