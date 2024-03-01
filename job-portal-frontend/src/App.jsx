import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Homepage from './pages/Homepage'
import FindSalaries from './pages/FindSalaries'
import FindCompanies from './pages/FindCompanies'
import Navigation from './Components/Navigation'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Navigation />} >

          <Route path='/find-salaries' element={<FindSalaries />} />
          <Route path='/find-companies' element={<FindCompanies />} />
        </Route>
      </Routes>
      <Routes>
        <Route path='/' element={<Homepage />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App