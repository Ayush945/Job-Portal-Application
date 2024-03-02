/**
 * Ayush Thapa
 * Navigation Component
 */
import React from 'react'
import { Outlet } from 'react-router'
import Navbar from './Navbar'
import Footer from './Footer'

function Navigation() {
    return (
        <>
            <Navbar />
            <Outlet />
            <Footer />
        </>
    )
}

export default Navigation