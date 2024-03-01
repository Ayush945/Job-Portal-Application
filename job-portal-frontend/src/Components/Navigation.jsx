import React from 'react'
import { Outlet } from 'react-router'
import Navbar from './Navbar'

function Navigation() {
    return (
        <>
            <Navbar />
            <Outlet />
        </>
    )
}

export default Navigation