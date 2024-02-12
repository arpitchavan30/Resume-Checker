import * as React from 'react';
import "../Tabs/Tabs.css";
import { Tab, Tabs } from '@mui/material';

import AdminPanelSettingsIcon from '@mui/icons-material/AdminPanelSettings';
import BadgeIcon from '@mui/icons-material/Badge';
import Admin_login from '../Pages/Admin/Admin';
import Employee_login from '../Pages/Employe/Employe';

const Tabs1 = () => {
  const [value, setValue] = React.useState(0);

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };

  return (
    <div>
      <Tabs
        value={value}
        onChange={handleChange}
        aria-label="icon label tabs example"
        sx={{
          '& .MuiTab-root': {
            flex: 1,
            backgroundColor :'var(--green)',
            display: 'flex',
            justifyContent: 'space-evenly',
          },
          
        }}
      >
        <Tab icon={<AdminPanelSettingsIcon />} label="Admin" />
        <Tab icon={<BadgeIcon />} label="Recruiter" />
      </Tabs>

      <div style={{backgroundColor:"var(--grey)"}}>
      {value === 0 && <Admin_login/>}
      {value === 1 && <Employee_login />}
      </div>
    </div>
  );
};

export default Tabs1;
