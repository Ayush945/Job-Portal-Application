import { Drawer, DrawerOverlay } from '@chakra-ui/react'
import React from 'react'

function ComapanySideBar() {
    const { isOpen, onOpen, onClose } = useDisclosure();
    const sidebarWidth = isOpen ? 'sm' : 'xs';
    return (
        <>
            <IconButton icon={<HamburgerIcon />} variant="ghost" onClick={onOpen} />
            <Drawer isOpen={isOpen} placement="left" size={sidebarWidth}>
                <DrawerOverlay />
                <DrawerContent bg="gray.100" p={4}>

                    <IconButton icon={<HamburgerIcon />} variant="ghost" onClick={onClose} borderRadius="full" size="sm" />

                    <nav className=" flex flex-col space-y-2">
                        <NavLink to="/company-profile" activeClassName="active" onClick={onClose}>
                            Company Profile
                        </NavLink>
                        <NavLink to="/post-job" activeClassName="active" onClick={onClose}>
                            Post Job
                        </NavLink>
                        <NavLink to="/applications" activeClassName="active" onClick={onClose}>
                            Applications
                        </NavLink>
                    </nav>
                </DrawerContent>
            </Drawer>
        </>
    )
}

export default ComapanySideBar