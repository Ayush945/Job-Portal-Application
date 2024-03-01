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

function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path='' element={<Navigation />} >
          <Route path='/' element={<Homepage />} />
          <Route path='/find-salaries' element={<FindSalaries />} />
          <Route path='/find-companies' element={<FindCompanies />} />
          <Route path='/profile' element={<Profile />} />
          <Route path='/notification' element={<Notification />} />
          <Route path='/message' element={<Message />} />
          <Route path='post-job' element={<PostJob />} />
        </Route>
      </Routes>



    </BrowserRouter>
  )
}

export default App